package com.example.cs_2340_assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.data.Exam;
import com.example.cs_2340_assignment_1.state.State;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.ExamViewHolder> {
    private List<Exam> mExamEntries;
    private Context mContext;

    public ExamListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mExamEntries = getTasks();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.exam_text_row_item, parent, false);

        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        mExamEntries = getTasks();
        Exam eEntry = mExamEntries.get(position);
        String courseName = eEntry.getAssociatedCourse().getName();
        String examName = eEntry.getName();
        String examLocation = eEntry.getNotes(); // location
        Timestamp examTime = eEntry.getStartTime();
        String formattedTime = examTime.toString();

        holder.courseName.setText(courseName.trim());
        holder.examName.setText(examName);
        holder.formattedExamTime.setText(formattedTime);
        holder.location.setText(examLocation);
    }

    @Override
    public int getItemCount() {
        getTasks();
        return mExamEntries.size();
    }

    public void setTasks(PriorityQueue<Exam> taskEntries) {
        mExamEntries = getTasks();
        notifyDataSetChanged();
    }

    public List<Exam> getTasks() {
        List<Exam> tasks = new ArrayList<>();
        for (var k: State.getCourseMap().keySet()) {
            tasks.addAll(Utils.priorityQueueToArrayList(State.getCourseMap().get(k).getExams()));
        }
        mExamEntries = tasks;
        return tasks;
    }

    public static class ExamViewHolder extends RecyclerView.ViewHolder {
        // Class variables for the task description and priority TextViews
        TextView courseName;
        TextView examName;
        TextView location;
        TimePicker examTime;
        DatePicker examDate;
        TextView formattedExamTime;

        public ExamViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name);
            examName = itemView.findViewById(R.id.exam_name);
            location = itemView.findViewById(R.id.exam_location);
            formattedExamTime = itemView.findViewById(R.id.exam_time);
        }
    }
}
