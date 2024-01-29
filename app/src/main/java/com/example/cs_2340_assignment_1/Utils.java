package com.example.cs_2340_assignment_1;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Class for miscellaneous utility methods used throughout the application.
 */
public class Utils {

    /**
     * Converts a priority queue to an ordered array list
     * @param priorityQueue priority queue
     * @return array list
     * @param <T> type parameter
     */
    public static <T> ArrayList<T> priorityQueueToArrayList(PriorityQueue<T> priorityQueue) {
        PriorityQueue<T> pq = new PriorityQueue<>(priorityQueue);
        ArrayList<T> list = new ArrayList<>(priorityQueue.size());
        while (pq.size() > 0) {
            list.add(pq.poll());
        }
        return list;
    }
}
