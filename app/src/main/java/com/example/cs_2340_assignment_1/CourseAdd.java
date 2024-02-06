package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.databinding.CourseAddFragmentBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.util.ArrayList;
import java.util.List;

public class CourseAdd extends Fragment {
    private CourseAddFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CourseAddFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonAdd = getActivity().findViewById(R.id.saveButton);
        EditText etTask = getActivity().findViewById(R.id.editTextTaskDescription);
        EditText courseInstructor = getActivity().findViewById(R.id.editcourseInstructor);
        EditText courseTime = getActivity().findViewById(R.id.editcourseTime);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etTask.getText().toString().trim();
                String instructorName = courseInstructor.getText().toString().trim();
                String cCourseTime = courseTime.getText().toString().trim();

                List<String> courseTimes = new ArrayList<>();
                courseTimes.add(cCourseTime);

                Course course = State.getFactory().createCourse(name, instructorName, courseTimes, "");
                AppExecutor.getInstance().diskIO().execute(new Runnable() {
                    @Override

                    public void run() {
                        CourseListAdapter courseListAdapter = new CourseListAdapter(getContext());
                        courseListAdapter.setTasks(State.getCourseMap());
                    }

                });
                NavHostFragment.findNavController(CourseAdd.this)
                        .navigate(R.id.navigateToCourses);


            }

        });


    }

    @Override
    public void onResume() {
        super.onResume();
        CourseListAdapter courseListAdapter = new CourseListAdapter(getContext());
        courseListAdapter.setTasks(State.getCourseMap());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}