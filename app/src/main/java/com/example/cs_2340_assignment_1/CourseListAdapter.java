package com.example.cs_2340_assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.state.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    private List<Course> mCourseEntries;

    private Context mContext;

    public CourseListAdapter(Context context) {
        mCourseEntries = new ArrayList<>();
        mContext = context;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mCourseEntries = getTasks();
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.course_text_row_item, parent, false);

        return new CourseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        mCourseEntries = getTasks();
        Course cEntry = mCourseEntries.get(position);
        String course = cEntry.getName();
        String courseInstructor = cEntry.getInstructorName();
        String courseTime = cEntry.getCourseTimes().get(0);

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

    public void setTasks(HashMap<String, Course> taskEntries) {
        mCourseEntries = getTasks();
        notifyDataSetChanged();
    }

    public List<Course> getTasks() {
        List<Course> tasks = new ArrayList<>();
        for (var k : State.getCourseMap().keySet()) {
            tasks.add(State.getCourseMap().get(k));
        }
        return tasks;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView courseName;
        TextView courseInstructor;
        TextView courseTime;


        public CourseViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_title);
            courseInstructor = itemView.findViewById(R.id.course_instructor);
            courseTime = itemView.findViewById(R.id.course_time);
        }
    }
}

