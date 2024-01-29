package com.example.cs_2340_assignment_1.state;

import com.example.cs_2340_assignment_1.data.Assignment;
import com.example.cs_2340_assignment_1.data.Course;
import com.example.cs_2340_assignment_1.data.Exam;
import com.example.cs_2340_assignment_1.data.TodoList;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Stores the application state at any given moment.
 */
public final class State {

    // FACTORY
    /**
     * Singular static factory instance for creating application objects.
     */
    private static final Factory factory = new Factory();

    // STATE FIELDS
    private static HashMap<String, Course> courseMap = new HashMap<>();
    private static final PriorityQueue<Assignment> assignmentsPriorityQueue = new PriorityQueue<>();
    private static final PriorityQueue<Exam> examsPriorityQueue = new PriorityQueue<>();
    private static HashMap<String, TodoList> todoLists = new HashMap<>();

    // METHODS
    public static HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public static PriorityQueue<Assignment> getAssignmentsPriorityQueue() {
        return assignmentsPriorityQueue;
    }

    public static PriorityQueue<Exam> getExamsPriorityQueue() {
        return examsPriorityQueue;
    }

    public static HashMap<String, TodoList> getTodoLists() {
        return todoLists;
    }

    private static void setCourseMap(HashMap<String, Course> map) {
        courseMap = map;
    }

    private static void setTodoLists(HashMap<String, TodoList> lists) {
        todoLists = lists;
    }

    // UPDATE
    /**
     * Updates state variables based on course map and lists.
     * Should be called when any creation, edit, or deletion is made.
     *
     * @param courseMap course map
     * @param todoLists lists
     */
    public static void update(HashMap<String, Course> courseMap, HashMap<String, TodoList> todoLists) {
        if (State.courseMap != courseMap) {
            setCourseMap(courseMap);
            assignmentsPriorityQueue.clear();
            examsPriorityQueue.clear();

            for (String key : courseMap.keySet()) {
                Course c = courseMap.get(key);
                if (c != null) {
                    assignmentsPriorityQueue.addAll(c.getAssignments());
                    examsPriorityQueue.addAll(c.getExams());
                }
            }
        }
        if (State.todoLists != todoLists) {
            setTodoLists(todoLists);
        }
    }
}
