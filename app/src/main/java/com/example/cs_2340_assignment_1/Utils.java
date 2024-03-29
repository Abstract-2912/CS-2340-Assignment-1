package com.example.cs_2340_assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Class for miscellaneous utility methods used throughout the application.
 */
public class Utils {

    /**
     * Converts a priority queue to an ordered array list
     *
     * @param priorityQueue priority queue
     * @param <T>           type parameter
     * @return array list
     */
    public static <T extends Comparable> ArrayList<T> priorityQueueToArrayList(PriorityQueue<T> priorityQueue) {
        PriorityQueue<T> pq = new PriorityQueue<>(priorityQueue);
        ArrayList<T> list = new ArrayList<>(priorityQueue.size());
        while (pq.size() > 0) {
            list.add(pq.poll());
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }
}
