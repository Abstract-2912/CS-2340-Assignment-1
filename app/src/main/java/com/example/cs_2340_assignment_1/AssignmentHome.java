package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.data.Assignment;
import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.databinding.AssignmentFragmentBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.util.HashMap;
import java.util.List;


public class AssignmentHome extends Fragment {
    private AssignmentFragmentBinding binding;
    private static AssignmentListAdapter assignmentListAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        assignmentListAdapter = new AssignmentListAdapter(getContext());
        binding = AssignmentFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_assignments);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL
                )
        );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(assignmentListAdapter);
        binding.fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AssignmentHome.this)
                        .navigate(R.id.navigateToAddAssignment);
            }
        });

        binding.sortByDate.setOnClickListener(
                e -> {
                    assignmentListAdapter.setSortingManner(true);
                }
        );

        binding.sortByClass.setOnClickListener(
                e -> {
                    assignmentListAdapter.setSortingManner(false);
                }
        );

        binding.back.setOnClickListener(
                e -> {
                    NavHostFragment.findNavController(AssignmentHome.this)
                            .navigate(R.id.navigateFromAssignmentsToHome);
                }
        );

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                return false; // We return false because we are not going to use it

            }

            // Called when a user swipes left or right on a ViewHolder

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                //  implement swipe to delete

                //get item position
                final int position = viewHolder.getAbsoluteAdapterPosition();


                // get list of Task

                final List<Assignment> tasks = assignmentListAdapter.getTasks(assignmentListAdapter.getSortingManner());

                AppExecutor.getInstance().diskIO().execute(new Runnable() {

                    @Override
                    public void run() {
                        Course c = tasks.get(position).getAssociatedCourse();
                        c.removeAssignment(tasks.get(position));
                        State.update(State.getCourseMap(), State.getTodoLists());
                    }

                });

                getTasks();

            }

        }).attachToRecyclerView(recyclerView);
    }

    private void getTasks() {
        AppExecutor.getInstance().diskIO().execute(new Runnable() {
            @Override

            public void run() {
                final HashMap<String, Assignment> tasks = State.getAssignmentsMap();
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        assignmentListAdapter.setTasks(tasks);
                    }
                });
            }
        });
    }

    public static AssignmentListAdapter getAssignmentListAdapter() {
        return assignmentListAdapter;
    }

    @Override
    public void onResume() {
        super.onResume();
        assignmentListAdapter.setTasks(new HashMap<>());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}