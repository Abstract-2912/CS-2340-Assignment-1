package com.example.cs_2340_assignment_1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Constants {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String courseName;


    @ColumnInfo(name = "Course Instructor")
    private String courseInstructor;
    @ColumnInfo(name = "Course Time")
    private String courseTime;

    public Constants(String cName, String cInstructor, String cTime) {

        this.courseName = cName;

        this.courseInstructor = cInstructor;

        this.courseTime = cTime;

    }

    public Constants() {

    }

    public int getId() {

        return id;

    }

    public String getCourseName() {

        return courseName;

    }

    public String getCourseInstructor() {

        return courseInstructor;

    }

   public String getCourseTime(){
        return courseTime;
   }

    public void setId(int id) {

        this.id = id;

    }

    public void setCourseName(String description) {

        this.courseName = description;

    }

    public void setCourseInstructor(String courseInstructor) {

        this.courseInstructor = courseInstructor;

    }

    public void setCourseTime(String courseTime) {

        this.courseTime = courseTime;

    }
}
