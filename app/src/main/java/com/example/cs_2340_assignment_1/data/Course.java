package com.example.cs_2340_assignment_1.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class responsible for storing data related to a course.
 *
 * @see List
 * @see ArrayList
 * @see PriorityQueue
 * @see Timestamp
 */
public final class Course {
    /**
     * Name of the course. (required)
     */
    private String name;

    /**
     * Name of the instructor. (required)
     */
    private String instructorName;

    /**
     * List of timestamp arrays for storing course times. (required)
     * First value of each list entry array denotes starting timestamp.
     * Second value of each list entry array denotes ending timestamp.
     */
    private List<Timestamp[]> courseTimes;

    /**
     * PriorityQueue of assignments associated with this course.
     */
    private PriorityQueue<Assignment> assignments;

    /**
     * PriorityQueue of exams associated with this course.
     */
    private PriorityQueue<Exam> exams;

    /**
     * String for miscellaneous information regarding the course.
     */
    private String notes;

    /**
     * Base constructor for initializing a course.
     *
     * @param name           course name
     * @param instructorName instructor name
     * @param courseTimes    course times
     * @param assignments    assignments
     * @param exams          exams
     * @param notes          notes
     * @see Course
     */
    private Course(
            String name,
            String instructorName,
            List<Timestamp[]> courseTimes,
            PriorityQueue<Assignment> assignments,
            PriorityQueue<Exam> exams,
            String notes
    ) {
        this.name = name;
        this.instructorName = instructorName;
        this.courseTimes = courseTimes;
        this.assignments = assignments;
        this.exams = exams;
        this.notes = notes;
    }

    /**
     * Maximal public constructor for a Course.
     *
     * @param name           name
     * @param instructorName instructor name
     * @param courseTimes    course times
     * @param notes          course notes
     * @see Course
     */
    public Course(String name, String instructorName, List<Timestamp[]> courseTimes, String notes) {
        this(name,
                instructorName,
                courseTimes,
                new PriorityQueue<>(),
                new PriorityQueue<>(),
                notes
        );
    }

    /**
     * Constructor for a course given course name, instructor name, and course times.
     *
     * @param name           course name
     * @param instructorName instructor name
     * @param courseTimes    course times
     * @see Course
     */
    public Course(String name, String instructorName, List<Timestamp[]> courseTimes) {
        this(name, instructorName, courseTimes, "");
    }

    /**
     * Constructor for a course given course name and instructor name.
     *
     * @param name           course name
     * @param instructorName instructor name
     * @see Course
     */
    public Course(String name, String instructorName) {
        this(name, instructorName, new ArrayList<>());
    }

    /**
     * Minimal public constructor for a Course.
     *
     * @param name course name
     * @see Course
     */
    public Course(String name) {
        this(name, "");
    }

    /**
     * Returns if course is equal to another object.
     *
     * @param o Object
     * @return equality value
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Course) {
            return this == o || (
                    this.name.equals(((Course) o).name)
                            && this.instructorName.equals(((Course) o).instructorName)
                            && this.courseTimes.equals(((Course) o).courseTimes)
                            && this.assignments.equals(((Course) o).assignments)
                            && this.exams.equals(((Course) o).exams)
                            && this.notes.equals(((Course) o).notes)
            );
        }
        return false;
    }

    /**
     * Adds an assignment to the assignments priority queue
     *
     * @param a Assignment
     */
    public void addAssignment(Assignment a) {
        assignments.add(a);
    }

    /**
     * Removes an assignment from the assignments priority queue
     *
     * @param a Assignment
     * @return action success value
     */
    public boolean removeAssignment(Assignment a) {
        if (assignments.contains(a)) {
            return assignments.remove(a);
        } else {
            throw new IllegalArgumentException(
                    "Assignment is not associated with class! Unable to remove."
            );
        }
    }

    /**
     * Adds an exam to the exams priority queue.
     *
     * @param e Exam
     */
    public void addExam(Exam e) {
        exams.add(e);
    }

    /**
     * Removes an exam from the exams priority queue.
     *
     * @param e Exam
     * @return action success value
     */
    public boolean removeExam(Exam e) {
        if (exams.contains(e)) {
            return exams.remove(e);
        } else {
            throw new IllegalArgumentException(
                    "Exam is not associated with class! Unable to remove it."
            );
        }
    }

    /**
     * Returns the name of the course.
     *
     * @return course name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course to a given name.
     *
     * @param name course name
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("Course name can not be null!");
        } else if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Course name can not be empty!");
        }
        this.name = name;
    }

    /**
     * Returns the instructor's name for the course.
     *
     * @return course instructor name
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * Sets the instructor's name of the course to a given name.
     *
     * @param instructorName course instructor name
     */
    public void setInstructorName(String instructorName) {
        if (instructorName == null) {
            throw new NullPointerException("Instructor name can not be null!");
        } else if (instructorName.isEmpty() || instructorName.isBlank()) {
            throw new IllegalArgumentException("Instructor name can not be empty!");
        }
        this.instructorName = instructorName;
    }

    /**
     * Returns the times of the course.
     *
     * @return course times
     */
    public List<Timestamp[]> getCourseTimes() {
        return courseTimes;
    }

    /**
     * Sets the course times to a given list of timestamps.
     *
     * @param courseTimes course times (list of timestamps)
     */
    public void setCourseTimes(List<Timestamp[]> courseTimes) {
        if (courseTimes == null) {
            throw new NullPointerException("Course times can not be null!");
        }
        this.courseTimes = courseTimes;
    }

    /**
     * Returns the priority queue of Assignments.
     *
     * @return Assignments priority queue.
     */
    public PriorityQueue<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Returns the priority queue of Exams.
     *
     * @return Exams priority queue.
     */
    public PriorityQueue<Exam> getExams() {
        return exams;
    }

    /**
     * Returns the notes associated with the course.
     *
     * @return course notes.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes associated with the course to a given string.
     *
     * @param notes course notes
     */
    public void setNotes(String notes) {
        if (notes == null) {
            notes = "";
        }
        this.notes = notes;
    }
}
