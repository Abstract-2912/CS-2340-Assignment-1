package com.example.cs_2340_assignment_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.R;
import com.example.cs_2340_assignment_1.data.TodoList;
import com.example.cs_2340_assignment_1.state.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>{
    private List<TodoList.TodoItem> mTodoEntries;
    private Context mContext;

    public TodoListAdapter(Context context) {
        mTodoEntries = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mTodoEntries = getTasks();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.todo_list_text_row_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        mTodoEntries = getTasks();
        TodoList.TodoItem tEntry = mTodoEntries.get(position);
        String name = tEntry.getName();
        String priority = String.valueOf(tEntry.getPriority());
        String details = String.valueOf(tEntry.getNotes());

        holder.taskName.setText(name);
        holder.taskPriority.setText(priority);
        holder.taskDetails.setText(details);
    }

    @Override
    public int getItemCount() {
        return mTodoEntries.size();
    }

    public void setTasks() {
        mTodoEntries = getTasks();
        notifyDataSetChanged();
    }

    public List<TodoList.TodoItem> getTasks() {
        List<TodoList.TodoItem> tasks = new ArrayList<>();
        var map = State.getTodoList().getTodoList();
        for (var k : map.keySet()) {
            tasks.add(map.get(k));
        }
        Collections.sort(tasks);
        Collections.reverse(tasks);
        return tasks;
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView taskPriority;
        TextView taskDetails;

        public TodoViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.task_name);
            taskPriority = itemView.findViewById(R.id.task_priority);
            taskDetails = itemView.findViewById(R.id.task_details);
        }
    }
}
