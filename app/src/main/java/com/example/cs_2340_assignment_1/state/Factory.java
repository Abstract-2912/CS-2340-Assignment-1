package com.example.cs_2340_assignment_1.state;

import com.example.cs_2340_assignment_1.data.Assignment;
import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.data.Exam;
import com.example.cs_2340_assignment_1.data.TodoList;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton package-private.
 * Responsible class responsible for creating courses, assignments, exams, and lists.
 *
 * @see State
 * @see Course
 * @see Assignment
 * @see Exam
 * @see TodoList
 */
public final class Factory {

    /**
     * Creates a course with parameters.
     *
     * @param name           name
     * @param instructorName instructor name
     * @param courseTimes    course times
     * @param notes          notes
     */
    public Course createCourse(
            String name,
            String instructorName,
            List<String> courseTimes,
            String notes
    ) {
        Course c = new Course(name, instructorName, courseTimes, notes);
        var courseMap = State.getCourseMap();
        if (courseMap.containsKey(c.getName())) { // edit a course
            courseMap.put(c.getName(), c);
            State.update(courseMap, State.getTodoList());
        } else {
            courseMap.put(c.getName(), c);
            State.update(courseMap, State.getTodoList());
        }
        return c;
    }

    /**
     * Creates a course with parameters.
     *
     * @param name           name
     * @param instructorName instructor name
     * @param courseTimes    course times
     */
    public Course createCourse(String name, String instructorName, List<String> courseTimes) {
        return createCourse(name, instructorName, courseTimes, "");
    }

    /**
     * Creates a course with parameters.
     *
     * @param name           name
     * @param instructorName instructor name
     */
    public Course createCourse(String name, String instructorName) { // not recommended
        return createCourse(name, instructorName, new ArrayList<>());
    }

    /**
     * Creates a course with parameters.
     *
     * @param name name
     */
    public Course createCourse(String name) { // not recommended
        return createCourse(name, "");
    }

    /**
     * Creates an assignment with parameters.
     *
     * @param title            title
     * @param associatedCourse associated course
     * @param assignedDate     assigned date
     * @param dueDate          due date
     * @param notes            notes
     */
    public Assignment createAssignment(
            String title,
            Course associatedCourse,
            Timestamp assignedDate,
            Timestamp dueDate,
            String notes
    ) {
        Assignment a = new Assignment(
                title,
                associatedCourse,
                assignedDate,
                dueDate,
                notes
        );
        var courseMap = State.getCourseMap();
        Course c = courseMap.getOrDefault(associatedCourse.getName(), null);
        if (c == null) {
            throw new IllegalArgumentException("Associated class does not exist!");
        } else {
            c.addAssignment(a);
            c.getAssignments().put(a.getTitle(), a);
            courseMap.put(c.getName(), c);
            State.update(courseMap, State.getTodoList());
        }
        return a;
    }

    /**
     * Creates an assignment with parameters.
     *
     * @param title            title
     * @param associatedCourse associated course
     * @param dueDate          due date
     * @param notes            notes
     */
    public Assignment createAssignment(
            String title,
            Course associatedCourse,
            Timestamp dueDate,
            String notes
    ) {
        return createAssignment(title, associatedCourse, null, dueDate, notes);
    }

    /**
     * Creates an assignment with parameters.
     *
     * @param title            title
     * @param associatedCourse associated course
     * @param dueDate          due date
     */
    public Assignment createAssignment(String title, Course associatedCourse, Timestamp dueDate) {
        return createAssignment(title, associatedCourse, dueDate, "");
    }

    /**
     * Creates an exam with parameters.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param endTime          end time
     * @param notes            notes
     */
    public Exam createExam(
            String name,
            Course associatedCourse,
            Timestamp startTime,
            Timestamp endTime,
            String notes
    ) {
        Exam e = new Exam(name, associatedCourse, startTime, endTime, notes);
        var courseMap = State.getCourseMap();
        Course c = courseMap.getOrDefault(associatedCourse.getName(), null);
        if (c == null) {
            throw new IllegalArgumentException("Associated class does not exist!");
        } else {
            c.addExam(e);
            courseMap.put(c.getName(), c);
            State.update(courseMap, State.getTodoList());
        }
        return e;
    }

    /**
     * Creates an exam with parameters.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param endTime          end time
     */
    public Exam createExam(
            String name,
            Course associatedCourse,
            Timestamp startTime,
            Timestamp endTime
    ) {
        return createExam(name, associatedCourse, startTime, endTime, "");
    }

    /**
     * Creates an exam with parameters.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param duration         duration
     * @param notes            notes
     */
    public Exam createExam(
            String name,
            Course associatedCourse,
            Timestamp startTime,
            Time duration,
            String notes
    ) {
        Exam e = new Exam(name, associatedCourse, startTime, duration, notes);
        var courseMap = State.getCourseMap();
        Course c = courseMap.getOrDefault(associatedCourse.getName(), null);
        if (c == null) {
            throw new IllegalArgumentException("Associated class does not exist!");
        } else {
            c.addExam(e);
            courseMap.put(c.getName(), c);
            State.update(courseMap, State.getTodoList());
        }
        return e;
    }

    /**
     * Creates an exam with parameters.
     *
     * @param name             name
     * @param associatedCourse associated course
     * @param startTime        start time
     * @param duration         duration
     */
    public Exam createExam(
            String name,
            Course associatedCourse,
            Timestamp startTime,
            Time duration
    ) {
        return createExam(name, associatedCourse, startTime, duration, "");
    }

    /**
     * Creates an item inside of an existing TodoList.
     *
     * @param list     existing list
     * @param name     name
     * @param priority priority
     * @param dueDate  due date
     * @param notes    notes
     */
    public TodoList createTodoListItem(
            TodoList list,
            String name,
            int priority,
            Timestamp dueDate,
            String notes
    ) {
        if (list == null) {
            throw new NullPointerException("List can not be null!");
        }
        list.addItem(name, priority, dueDate, notes);
        State.update(State.getCourseMap(), State.getTodoList());
        return list;
    }
}
