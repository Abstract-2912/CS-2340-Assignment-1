package com.example.cs_2340_assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    // Class variables for the List that holds task data and the Context
    private List<Constants> mCourseEntries;

    private Context mContext;

    // Date formatter


    // the adapter constructor
    public CourseListAdapter(Context context) {
        mContext = context;

    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.text_row_item, parent, false);

        return new CourseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

        // Determine the values of the wanted data

        Constants cEntry = mCourseEntries.get(position);
        String course = cEntry.getCourseName();
        String courseInstructor = cEntry.getCourseInstructor();
        String courseTime = cEntry.getCourseTime();
//        Toast.makeText(mContext,description,Toast.LENGTH_LONG).show();
        //Set values
        holder.courseName.setText(course);
        holder.courseInstructor.setText(courseInstructor);
        holder.courseTime.setText(courseTime);
    }

    @Override
    public int getItemCount() {
        if (mCourseEntries == null) {
            return 0;
        }

        return mCourseEntries.size();
    }
    /**

     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTasks(List<Constants> taskEntries) {
        mCourseEntries = taskEntries;
        notifyDataSetChanged();
    }
    public List<Constants> getTasks() {
        return mCourseEntries;
    }
    // Inner class for creating ViewHolders
   public static class CourseViewHolder extends RecyclerView.ViewHolder {
        // Class variables for the task description and priority TextViews
        TextView courseName;
        TextView courseInstructor;
        TextView courseTime;
        public CourseViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.taskDescription);
            courseInstructor = itemView.findViewById(R.id.course_instructor);
            courseTime = itemView.findViewById(R.id.course_time);
        }
    }
}

