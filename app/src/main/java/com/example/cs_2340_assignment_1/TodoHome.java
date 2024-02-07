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

import com.example.cs_2340_assignment_1.data.TodoList;
import com.example.cs_2340_assignment_1.databinding.TodoFragmentBinding;
import com.example.cs_2340_assignment_1.state.State;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoHome extends Fragment {
    private TodoFragmentBinding binding;
    private TodoListAdapter todoListAdapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        todoListAdapter = new TodoListAdapter(getContext());
        binding = TodoFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getActivity().findViewById(R.id.recycler_view_toDoList);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL
                )
        );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(todoListAdapter);
        binding.fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TodoHome.this)
                        .navigate(R.id.navigateToAddTodoItems);
            }
        });

        binding.back.setOnClickListener(
                e -> {
                    NavHostFragment.findNavController(TodoHome.this)
                            .navigate(R.id.navigateFromTodoListsToHome);
                }
        );

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                return false; // We return false because we are not going to use it

            }

            // Called when a user swipes left or right on a ViewHolder

            List<TodoList.TodoItem> tasks;

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                //  implement swipe to delete

                //get item position
                final int position = viewHolder.getAbsoluteAdapterPosition();


                // get list of Task

                tasks = todoListAdapter.getTasks();

                AppExecutor.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        TodoList.TodoItem t = tasks.get(position);
                        State.getTodoList().removeItem(t);
                        State.update(State.getCourseMap(), State.getTodoList());
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        todoListAdapter.setTasks();
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        todoListAdapter.setTasks();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}