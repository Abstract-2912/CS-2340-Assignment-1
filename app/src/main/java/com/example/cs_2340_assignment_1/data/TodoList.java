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
     * Name of TodoList
     */
    private String name;

    /**
     * Underlying priority queue for TodoList
     */
    private final PriorityQueue<TodoItem> todoListStructure;

    /**
     * Constructs a TodoList off of an existing priority queue.
     *
     * @param todoListStructure list priority queue
     */
    public TodoList(String name, PriorityQueue<TodoItem> todoListStructure) {
        if (name == null) {
            throw new NullPointerException("List name can not be null!");
        } else if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("List name can not be empty!");
        }
        this.todoListStructure = new PriorityQueue<>(todoListStructure);
    }

    /**
     * Default TodoList constructor.
     */
    public TodoList(String name) {
        this(name, new PriorityQueue<>());
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
     * Returns the name of the TodoList.
     *
     * @return name
     */
    public String getName() {
        return name;
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

            setName(name);
            setPriority(priority);
            setDueDate(dueDate);
            setNotes(notes);
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

        /**
         * Returns the name of the item.
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the item to a given name.
         * @param name given name
         */
        public void setName(String name) {
            if (name == null) {
                throw new NullPointerException("Item name can not be null!");
            } else if (name.isBlank() || name.isEmpty()) {
                throw new IllegalArgumentException("Item name can not be empty!");
            }
            this.name = name;
        }

        /**
         * Returns the priority of item.
         * @return priority
         */
        public int getPriority() {
            return priority;
        }

        /**
         * Sets the priority of an item to a given priority.
         * @param priority given priority
         */
        public void setPriority(int priority) {
            this.priority = priority;
        }

        /**
         * Returns the due date of the item.
         * @return item due date
         */
        public Timestamp getDueDate() {
            return dueDate;
        }

        /**
         * Sets the due date of the item to a given timestamp.
         * @param dueDate given timestamp
         */
        public void setDueDate(Timestamp dueDate) {
            this.dueDate = dueDate;
        }

        /**
         * Returns the associated notes for the item.
         * @return notes
         */
        public String getNotes() {
            return notes;
        }

        /**
         * Sets the associated notes for the item to a given string.
         * @param notes given string
         */
        public void setNotes(String notes) {
            if (notes == null) {
                notes = "";
            }
            this.notes = notes;
        }
    }
}
