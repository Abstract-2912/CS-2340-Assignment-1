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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.databinding.FragmentThirdBinding;
import com.example.cs_2340_assignment_1.state.Factory;
import com.example.cs_2340_assignment_1.state.State;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
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
                String name =  etTask.getText().toString().trim();
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
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_SecondFragment);


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