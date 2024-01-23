package com.example.cs_2340_assignment_1.data;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Class responsible for storing data related to an exam.
 *
 * @see Comparable
 * @see Timestamp
 * @see Time
 * @see Course
 */
public final class Exam implements Comparable<Exam> {
    /**
     * Exam name. (required)
     */
    private String name;

    /**
     * Associated course for exam. (required)
     */
    private Course associatedCourse;

    /**
     * Start time for exam. (required)
     */
    private Timestamp startTime;

    /**
     * End time for exam. (required)
     */
    private Timestamp endTime;

    /**
     * Notes for exam.
     */
    private String notes;

    /**
     * Constructor that instantiates an exam based on name, associated course, start time, end time, and notes.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param endTime          end time
     * @param notes            notes
     */
    public Exam(String name, Course associatedCourse, Timestamp startTime, Timestamp endTime, String notes) {
        if (name == null || associatedCourse == null || startTime == null || endTime == null) {
            throw new NullPointerException("Missing fields: can not instantiate exam object");
        }

        this.name = name;
        this.associatedCourse = associatedCourse;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;

        this.associatedCourse.addExam(this);
    }

    /**
     * Constructor that instantiates an exam based on name, associated course, start time, duration, and notes.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param duration         duration
     * @param notes            notes
     */
    public Exam(String name, Course associatedCourse, Timestamp startTime, Time duration, String notes) {
        if (name == null || associatedCourse == null || startTime == null || endTime == null) {
            throw new NullPointerException("Missing fields: can not instantiate exam object");
        }

        this.name = name;
        this.associatedCourse = associatedCourse;
        this.startTime = startTime;
        this.endTime = new Timestamp(startTime.getTime() + duration.getTime());
        this.notes = notes;

        this.associatedCourse.addExam(this);
    }

    /**
     * Constructor that instantiates an exam based on name, associated course, start time, and end time.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param endTime          end time
     */
    public Exam(String name, Course associatedCourse, Timestamp startTime, Timestamp endTime) {
        this(name, associatedCourse, startTime, endTime, "");
    }

    /**
     * Constructor that instantiates an exam based on name, associated course, start time, and duration.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param duration         duration
     */
    public Exam(String name, Course associatedCourse, Timestamp startTime, Time duration) {
        this(name, associatedCourse, startTime, duration, "");
    }

    /**
     * Compares two Exam objects.
     *
     * @param o the exam to be compared.
     * @return comparison value
     * @see Timestamp#compareTo(Timestamp)
     */
    @Override
    public int compareTo(Exam o) {
        if (o == this || o.equals(this))
            return 0;
        return startTime.compareTo(o.startTime);
    }

    /**
     * Returns if the exam is equal to another object.
     *
     * @param o Object
     * @return Equality Value.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Exam) {
            var castedObj = (Exam) o;
            return castedObj.name.equals(this.name)
                    && castedObj.associatedCourse.equals(this.associatedCourse)
                    && castedObj.startTime.equals(this.startTime)
                    && castedObj.endTime.equals(this.endTime)
                    && castedObj.notes.equals(this.notes);
        }
        return false;
    }

    /**
     * Returns the name of the exam.
     *
     * @return exam name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the exam to a given name.
     *
     * @param name given name
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("Exam can not have null name!");
        } else if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Exam can not have empty name!");
        }
        this.name = name;
    }

    /**
     * Returns the associated course for the exam.
     *
     * @return associated course
     */
    public Course getAssociatedCourse() {
        return associatedCourse;
    }

    /**
     * Sets the associated course of the exam to a given course.
     *
     * @param associatedCourse given course
     */
    public void setAssociatedCourse(Course associatedCourse) {
        if (associatedCourse == null) {
            throw new NullPointerException("Associated course can not be null!");
        }
        this.associatedCourse.removeExam(this);
        this.associatedCourse = associatedCourse;
        this.associatedCourse.addExam(this);
    }

    /**
     * Returns the start time of the exam.
     *
     * @return start time
     */
    public Timestamp getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the exam to a given time.
     *
     * @param startTime given time
     */
    public void setStartTime(Timestamp startTime) {
        if (startTime == null) {
            throw new NullPointerException("Start time can not be null!");
        }
        this.startTime = startTime;
    }

    /**
     * Returns the end time of the exam.
     *
     * @return end time
     */
    public Timestamp getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the exam to a given time.
     *
     * @param endTime given time
     */
    public void setEndTime(Timestamp endTime) {
        if (endTime == null) {
            throw new NullPointerException("End time can not be null!");
        }
        this.endTime = endTime;
    }

    /**
     * Returns the associated notes for the exam.
     *
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the associated notes for the exam to a given string.
     *
     * @param notes given string
     */
    public void setNotes(String notes) {
        if (notes == null) {
            notes = "";
        }
        this.notes = notes;
    }
}
