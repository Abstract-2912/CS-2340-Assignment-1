package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.data.Exam;
import com.example.cs_2340_assignment_1.databinding.FragmentSeventhBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.sql.Timestamp;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamAdd extends Fragment {
    private FragmentSeventhBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSeventhBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExamListAdapter examListAdapter = new ExamListAdapter(getContext());
        Button buttonAdd = getActivity().findViewById(R.id.saveButtonExams);
        EditText examName = getActivity().findViewById(R.id.examName);
        EditText courseName = getActivity().findViewById(R.id.courseName);
        TimePicker examTime = getActivity().findViewById(R.id.examTime);
        DatePicker examDate = getActivity().findViewById(R.id.examDate);
        EditText examLocation = getActivity().findViewById(R.id.examLocation);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eName = examName.getText().toString().trim();
                String cName = courseName.getText().toString().trim();
                String eLoc = examLocation.getText().toString().trim();
                Timestamp eTime = new Timestamp(
                        examDate.getYear() - 1900,
                        examDate.getMonth(),
                        examDate.getDayOfMonth(),
                        examTime.getHour(),
                        examTime.getMinute(),
                        0,
                        0
                    );

                Exam e = State.getFactory().createExam(
                        eName,
                        State.getCourseMap().get(cName),
                        eTime, new Timestamp(0),
                        eLoc
                );
                Course c = State.getCourseMap().get(cName);
                if (c != null) {
                    c.removeExam(e);
                }

                examListAdapter.setTasks(State.getExamsPriorityQueue());
                NavHostFragment.findNavController(ExamAdd.this)
                        .navigate(R.id.navigateToExams);


            }

        });


    }

    @Override
    public void onResume() {
        super.onResume();
        ExamListAdapter examListAdapter = new ExamListAdapter(getContext());
        examListAdapter.setTasks(State.getExamsPriorityQueue());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}