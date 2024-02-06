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

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.data.Exam;
import com.example.cs_2340_assignment_1.databinding.FragmentSecondBinding;
import com.example.cs_2340_assignment_1.databinding.FragmentSixthBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A simple {@link Fragment} subclass.
 */
public class SixthFragment extends Fragment {
    private FragmentSixthBinding binding;
    private ExamListAdapter examListAdapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        examListAdapter = new ExamListAdapter(getContext());
        binding = FragmentSixthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_exams);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL
                )
        );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(examListAdapter);
        binding.fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_sixthFragment_to_seventhFragment);
            }
        });

        binding.back.setOnClickListener(
                e -> {
                    NavHostFragment.findNavController(SixthFragment.this)
                            .navigate(R.id.action_SecondFragment_to_FirstFragment);
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

                final List<Exam> tasks = examListAdapter.getTasks();

                AppExecutor.getInstance().diskIO().execute(new Runnable() {

                    @Override
                    public void run() {
                        Course c = tasks.get(position).getAssociatedCourse();
                        String examName = tasks.get(position).getName();
                        c.removeExam(examName);
                        State.update(State.getCourseMap(), State.getTodoLists());
//                        courseListAdapter.setTasks(State.getCourseMap());
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

                final PriorityQueue<Exam> tasks = State.getExamsPriorityQueue();


                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        examListAdapter.setTasks(tasks);
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        examListAdapter.setTasks(State.getExamsPriorityQueue());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}