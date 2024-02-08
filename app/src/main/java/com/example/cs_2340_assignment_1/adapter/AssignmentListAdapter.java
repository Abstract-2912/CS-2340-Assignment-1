package com.example.cs_2340_assignment_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.R;
import com.example.cs_2340_assignment_1.data.Assignment;
import com.example.cs_2340_assignment_1.state.State;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class AssignmentListAdapter extends RecyclerView.Adapter<AssignmentListAdapter.AssignmentViewHolder> {
    private List<Assignment> mAssignmentEntries;
    private Context mContext;
    private boolean sortedByDueDate = false;

    public AssignmentListAdapter(Context context) {
        mContext = context;
        sortedByDueDate = true;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mAssignmentEntries = getTasks(sortedByDueDate);
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.assignment_text_row_item, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {
        mAssignmentEntries = getTasks(sortedByDueDate);
        Assignment aEntry = mAssignmentEntries.get(position);
        String assignmentName = aEntry.getTitle();
        String courseName = aEntry.getAssociatedCourse().getName();
        Timestamp assignmentDueDate = aEntry.getDueDate();
        String formattedTime = assignmentDueDate.toString();

        holder.assignmentName.setText(assignmentName);
        holder.courseName.setText(courseName.trim());
        holder.formattedDueDate.setText(formattedTime);
    }

    @Override
    public int getItemCount() {
        if (mAssignmentEntries == null) {
            return 0;
        }
        return mAssignmentEntries.size();
    }

    public void setTasks(HashMap<String, Assignment> taskEntries) {
        mAssignmentEntries = getTasks(sortedByDueDate);
        notifyDataSetChanged();
    }

    public List<Assignment> getTasks(boolean sortedByDueDate) {
        List<Assignment> tasks = new ArrayList<>();
        ArrayList<String> keySet = new ArrayList<>(State.getCourseMap().keySet());
        Collections.sort(keySet);
        for (var k : keySet) {
            ArrayList<Assignment> courseTasks = new ArrayList<>();
            if (State.getCourseMap().get(k).getAssignments() != null) {
                for (var k1 : Objects.requireNonNull(State.getCourseMap().get(k)).getAssignments().keySet()) {
                    courseTasks.add(Objects.requireNonNull(State.getCourseMap().get(k)).getAssignments().get(k1));
                }
                if (sortedByDueDate) {
                    tasks.addAll(courseTasks);
                    Collections.sort(tasks);
                } else {
                    Collections.sort(courseTasks);
                    tasks.addAll(courseTasks);
                }
            }
        }
        mAssignmentEntries = tasks;
        return tasks;
    }

    public void setSortingManner(boolean b) {
        sortedByDueDate = b;
        setTasks(new HashMap<>());
    }

    public boolean getSortingManner() {
        return sortedByDueDate;
    }

    public static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        TextView assignmentName;
        TextView courseName;
        TextView formattedDueDate;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assignmentName = itemView.findViewById(R.id.assignment_name);
            courseName = itemView.findViewById(R.id.course_name);
            formattedDueDate = itemView.findViewById(R.id.due_date);
        }
    }

}
