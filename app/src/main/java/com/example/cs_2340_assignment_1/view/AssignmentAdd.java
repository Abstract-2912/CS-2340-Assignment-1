package com.example.cs_2340_assignment_1.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cs_2340_assignment_1.R;
import com.example.cs_2340_assignment_1.adapter.AssignmentListAdapter;
import com.example.cs_2340_assignment_1.data.Assignment;
import com.example.cs_2340_assignment_1.databinding.AssignmentAddFragmentBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.sql.Timestamp;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentAdd extends Fragment {
    private AssignmentAddFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = AssignmentAddFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    TextView assignmentName;
    TextView courseName;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AssignmentListAdapter assignmentListAdapter = AssignmentHome.getAssignmentListAdapter();
        Button buttonAdd = getActivity().findViewById(R.id.assignments_save_button);
        assignmentName = getActivity().findViewById(R.id.assignment_name);
        courseName = getActivity().findViewById(R.id.course_name);
        TimePicker assignmentTime = getActivity().findViewById(R.id.assignment_time);
        DatePicker assignmentDate = getActivity().findViewById(R.id.assignment_date);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignmentName = getActivity().findViewById(R.id.assignment_name);
                courseName = getActivity().findViewById(R.id.course_name);

                String aName = assignmentName.getText().toString().trim();
                String cName = courseName.getText().toString().trim();
                Timestamp aTime = new Timestamp(
                        assignmentDate.getYear() - 1900,
                        assignmentDate.getMonth(),
                        assignmentDate.getDayOfMonth(),
                        assignmentTime.getHour(),
                        assignmentTime.getMinute(),
                        0,
                        0
                );

                Assignment a = State.getFactory().createAssignment(
                        aName,
                        State.getCourseMap().get(cName),
                        new Timestamp(0), aTime,
                        ""
                );

                assignmentListAdapter.setTasks(State.getAssignmentsMap());
                NavHostFragment.findNavController(AssignmentAdd.this)
                        .navigate(R.id.navigateToAssignments);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        AssignmentListAdapter examListAdapter = new AssignmentListAdapter(getContext());
        examListAdapter.setTasks(State.getAssignmentsMap());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}