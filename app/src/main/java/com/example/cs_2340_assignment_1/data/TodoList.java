package com.example.cs_2340_assignment_1.data;

import java.sql.Timestamp;
import java.util.PriorityQueue;

/**
 * Class responsible for storing data related to an to-do list.
 *
 * @see Timestamp
 * @see PriorityQueue
 * @see TodoItem
 */
public class TodoList {

    /**
     * Underlying priority queue for TodoList
     */
    private PriorityQueue<TodoItem> todoListStructure;

    /**
     * Constructs a TodoList off of an existing priority queue.
     *
     * @param todoListStructure list priority queue
     */
    public TodoList(PriorityQueue<TodoItem> todoListStructure) {
        this.todoListStructure = new PriorityQueue<>(todoListStructure);
    }

    /**
     * Default TodoList constructor.
     */
    public TodoList() {
        this.todoListStructure = new PriorityQueue<>();
    }

    /**
     * Adds an item to the TodoList
     *
     * @param name     item name
     * @param priority item priority
     * @param dueDate  item due date
     * @param notes    item notes
     */
    public void addItem(String name, int priority, Timestamp dueDate, String notes) {
        TodoItem item = new TodoItem(name, priority, dueDate, notes);
        todoListStructure.add(item);
    }

    /**
     * Adds an item to the TodoList
     *
     * @param item item
     */
    public void addItem(TodoItem item) {
        todoListStructure.add(item);
    }

    /**
     * Removes an item from the TodoList
     *
     * @param name     item name
     * @param priority item priority
     * @param dueDate  item due date
     * @param notes    item notes
     */
    public void removeItem(String name, int priority, Timestamp dueDate, String notes) {
        TodoItem item = new TodoItem(name, priority, dueDate, notes);
        todoListStructure.remove(item);
    }

    /**
     * Adds an item to the TodoList
     *
     * @param item item
     */
    public void removeItem(TodoItem item) {
        todoListStructure.remove(item);
    }

    /**
     * Returns the underlying priority queue structure.
     *
     * @return priority queue
     */
    public PriorityQueue<TodoItem> getTodoList() {
        return todoListStructure;
    }

    /**
     * Base class that represents a TodoItem.
     *
     * @see Timestamp
     * @see Comparable
     */
    private static class TodoItem implements Comparable<TodoItem> {

        /**
         * Item name (required)
         */
        private String name;

        /**
         * Priority for item
         */
        private int priority;

        /**
         * Due date for item
         */
        private Timestamp dueDate;

        /**
         * Notes for item
         */
        private String notes;

        /**
         * Constructs a TodoItem.
         *
         * @param name     item name
         * @param priority item priority
         * @param dueDate  item due date
         * @param notes    item notes
         */
        public TodoItem(String name, int priority, Timestamp dueDate, String notes) {
            if (name == null) {
                throw new NullPointerException("Can not create null named todo item");
            }

            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
            this.notes = notes;
        }

        /**
         * Constructs a TodoItem.
         *
         * @param name     item name
         * @param priority item priority
         * @param notes    item notes
         */
        public TodoItem(String name, int priority, String notes) {
            this(name, priority, null, notes);
        }

        /**
         * Constructs a TodoItem.
         *
         * @param name  item name
         * @param notes item notes
         */
        public TodoItem(String name, String notes) {
            this(name, 0, notes);
        }

        /**
         * Constructs a TodoItem.
         *
         * @param name item name
         */
        public TodoItem(String name) {
            this(name, "");
        }

        /**
         * Compares a two TodoItems
         *
         * @param o the object to be compared.
         * @return comparison value
         */
        @Override
        public int compareTo(TodoItem o) {
            if (o == this || o.equals(this))
                return 0;

            if (this.dueDate == null || o.dueDate == null) {
                return Integer.compare(this.priority, o.priority);
            } else {
                if (this.priority == o.priority) {
                    if (this.dueDate.equals(o.dueDate)) {
                        return this.name.compareTo(o.name);
                    }
                    return this.dueDate.compareTo(o.dueDate);
                }
                return Integer.compare(this.priority, o.priority);
            }
        }

        /**
         * Returns if the TodoItem is equal to another object.
         *
         * @param o Object
         * @return equality value
         */
        @Override
        public boolean equals(Object o) {
            if (o instanceof TodoItem) {
                var castedObj = (TodoItem) o;
                return castedObj.name.equals(this.name) && castedObj.priority == this.priority && castedObj.dueDate.equals(dueDate);
            }
            return false;
        }
    }
}
