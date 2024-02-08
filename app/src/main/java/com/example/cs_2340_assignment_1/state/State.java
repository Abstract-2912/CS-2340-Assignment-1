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
    private static final HashMap<String, Assignment> assignmentMap = new HashMap<>();
    private static final PriorityQueue<Exam> examsPriorityQueue = new PriorityQueue<>();
    private static TodoList todoList = new TodoList("list");

    // METHODS
    public static Factory getFactory() {
        return factory;
    }

    public static HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public static HashMap<String, Assignment> getAssignmentsMap() {
        return assignmentMap;
    }

    public static PriorityQueue<Exam> getExamsPriorityQueue() {
        return examsPriorityQueue;
    }

    public static TodoList getTodoList() {
        return todoList;
    }

    public static void setCourseMap(HashMap<String, Course> map) {
        courseMap = map;
    }

    public static void setTodoList(TodoList list) {
        todoList = list;
    }

    // UPDATE
    /**
     * Updates state variables based on course map and lists.
     * Should be called when any creation, edit, or deletion is made.
     *
     * @param courseMap course map
     * @param todoList list
     */
    public static void update(HashMap<String, Course> courseMap, TodoList todoList) {
        setCourseMap(courseMap);
        assignmentMap.clear();
        examsPriorityQueue.clear();

        for (String key : courseMap.keySet()) {
            Course c = courseMap.get(key);
            if (c != null) {
                for (String a: c.getAssignments().keySet()) {
                    assignmentMap.put(c.getAssignments().get(a).getTitle(), c.getAssignments().get(a));
                }
                examsPriorityQueue.addAll(c.getExams());
            }
        }

        setTodoList(todoList);
    }
}
