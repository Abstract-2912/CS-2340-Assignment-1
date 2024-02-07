package com.example.cs_2340_assignment_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.cs_2340_assignment_1.data.TodoList;
import com.example.cs_2340_assignment_1.databinding.TodoAddFragmentBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.sql.Timestamp;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoAdd extends Fragment {

    private TodoAddFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TodoAddFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    TextView taskName;
    TextView taskPriority;
    TextView taskDetails;
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TodoListAdapter todoListAdapter = new TodoListAdapter(getContext());

        Button buttonAdd = getActivity().findViewById(R.id.saveButtonTodo);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskName = getActivity().findViewById(R.id.editTodoItemName);
                taskPriority = getActivity().findViewById(R.id.editTodoItemPriority);
                taskDetails = getActivity().findViewById(R.id.editTodoItemDetails);

                String tName = taskName.getText().toString().trim();
                int tPrio = Integer.parseInt(taskPriority.getText().toString().trim());
                String tDet = taskDetails.getText().toString().trim();

                TodoList e = State.getFactory().createTodoListItem(
                        State.getTodoList(),
                        tName,
                        tPrio, new Timestamp(0),
                        tDet
                );

                todoListAdapter.setTasks();
                NavHostFragment.findNavController(TodoAdd.this)
                        .navigate(R.id.navigateToTodoLists);
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        TodoListAdapter todoListAdapter = new TodoListAdapter(getContext());
        todoListAdapter.setTasks();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}