package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.databinding.FragmentSecondBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.util.HashMap;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    AppDataBase appDataBase;
    CourseListAdapter courseListAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        courseListAdapter = new CourseListAdapter(getContext());
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(courseListAdapter);
        appDataBase = AppDataBase.getsInstance(getContext());
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });
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

                final List<Course> tasks = courseListAdapter.getTasks();

                AppExecutor.getInstance().diskIO().execute(new Runnable() {

                    @Override
                    public void run() {
                        State.getCourseMap().remove(tasks.get(position).getName());
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

                final HashMap<String, Course> tasks = State.getCourseMap();


                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        courseListAdapter.setTasks(tasks);
                    }
                });

            }

        });

    }
    @Override
    public void onResume() {
        super.onResume();
        courseListAdapter.setTasks(State.getCourseMap());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}