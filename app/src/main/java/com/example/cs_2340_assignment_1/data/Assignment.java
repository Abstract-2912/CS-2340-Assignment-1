package com.example.cs_2340_assignment_1.data;

import java.sql.Timestamp;

/**
 * Class responsible for storing data related to an assignment.
 *
 * @see Comparable
 * @see Timestamp
 * @see Course
 */
public final class Assignment implements Comparable<Assignment> {
    /**
     * Assignment title. (required)
     */
    private String title;

    /**
     * Associated course for assignment. (required)
     */
    private Course associatedCourse;

    /**
     * Assigned date for assignment.
     */
    private Timestamp assignedDate;

    /**
     * Due date for assignment. (required)
     */
    private Timestamp dueDate;

    /**
     * Notes for assignment
     */
    private String notes;

    /**
     * Maximal public constructor for an Assignment.
     *
     * @param title            assignment title
     * @param associatedCourse associated course
     * @param assignedDate     assignment assigned date
     * @param dueDate          assignment due date
     * @param notes            assignment notes
     */
    public Assignment(
            String title,
            Course associatedCourse,
            Timestamp assignedDate,
            Timestamp dueDate,
            String notes
    ) {
        if (title == null || associatedCourse == null || dueDate == null) {
            throw new NullPointerException("Missing fields: can not instantiate assignment object");
        }

        this.title = title;
        this.associatedCourse = associatedCourse;
        this.assignedDate = assignedDate;
        this.dueDate = dueDate;
        this.notes = notes;

        this.associatedCourse.addAssignment(this);
    }

    /**
     * Constructs an Assignment object based on title, associated course, due date, and notes
     *
     * @param title            assignment title
     * @param associatedCourse associated course
     * @param dueDate          assignment due date
     * @param notes            assignment notes
     */
    private Assignment(String title, Course associatedCourse, Timestamp dueDate, String notes) {
        this(title, associatedCourse, null, dueDate, notes);
    }

    /**
     * Minimal public constructor for an Assignment.
     *
     * @param title            assignment title
     * @param associatedCourse associated course
     * @param dueDate          assignment due date
     */
    private Assignment(String title, Course associatedCourse, Timestamp dueDate) {
        this(title, associatedCourse, dueDate, "");
    }

    /**
     * Compares two Assignment objects.
     *
     * @param o the assignment to be compared.
     * @return comparison value
     * @see Timestamp#compareTo(Timestamp)
     */
    @Override
    public int compareTo(Assignment o) {
        if (o == this || o.equals(this))
            return 0;
        return dueDate.compareTo(o.dueDate);
    }

    /**
     * Returns if the assignment is equal to another object.
     *
     * @param o Object
     * @return Equality Value.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Assignment) {
            var castedObj = (Assignment) o;
            return castedObj.title.equals(this.title)
                    && castedObj.associatedCourse.equals(this.associatedCourse)
                    && castedObj.assignedDate.equals(this.assignedDate)
                    && castedObj.dueDate.equals(this.dueDate)
                    && castedObj.notes.equals(this.notes);
        }
        return false;
    }

    /**
     * Returns the title of the assignment.
     *
     * @return assignment title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the assignment to a given title.
     *
     * @param title assignment title
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("Assignment title can not be null!");
        } else if (title.isEmpty() || title.isBlank()) {
            throw new IllegalArgumentException("Assignment title can not be empty!");
        }
        this.title = title;
    }

    /**
     * Returns the associated course for the assignment.
     *
     * @return associated course
     */
    public Course getAssociatedCourse() {
        return associatedCourse;
    }

    /**
     * Sets the associated course for the assignment to a given course.
     *
     * @param associatedCourse associated course
     */
    public void setAssociatedCourse(Course associatedCourse) {
        if (associatedCourse == null) {
            throw new NullPointerException("Associated course can not be null!");
        }
        this.associatedCourse.removeAssignment(this);
        this.associatedCourse = associatedCourse;
        this.associatedCourse.addAssignment(this);
    }

    /**
     * Returns the assigned date.
     *
     * @return assigned date
     */
    public Timestamp getAssignedDate() {
        return assignedDate;
    }

    /**
     * Sets the assigned date to a given date.
     *
     * @param assignedDate given date
     */
    public void setAssignedDate(Timestamp assignedDate) {
        if (assignedDate == null) {
            throw new NullPointerException("Assigned date can not be null!");
        }
        this.assignedDate = assignedDate;
    }

    /**
     * Returns the due date.
     *
     * @return due date
     */
    public Timestamp getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date to a given date.
     *
     * @param dueDate given date
     */
    public void setDueDate(Timestamp dueDate) {
        if (dueDate == null) {
            throw new NullPointerException("Due date can not be null!");
        }
        this.dueDate = dueDate;
    }

    /**
     * Returns the notes for the assignment.
     *
     * @return assignment notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes for the assignment to a given string.
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
