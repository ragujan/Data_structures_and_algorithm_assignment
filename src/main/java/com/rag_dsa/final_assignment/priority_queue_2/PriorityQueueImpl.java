package com.rag_dsa.final_assignment.priority_queue_2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.rag_dsa.final_assignment.LinkedList.LinkedList;

public class PriorityQueueImpl<T extends Comparable<T>> {

    private LinkedList<T> heap;
    // private ArrayList<T> heap;

    public PriorityQueueImpl() {
        heap = new LinkedList<>();

    }

    public void add(T item) {
        heap.add(item);
        siftUp();
    }

    // to remove element at the first index
    public T poll() {

        if (heap.size() == 0) {
            throw new NoSuchElementException("Priority Queue is Empty");
        }

        T item = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            siftDown();
        }
        return item;
    }

    private void siftUp() {
        int index = heap.size() - 1;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T item = heap.get(index);

            T parent = heap.get(parentIndex);

            if (item.compareTo(parent) >= 0) {
                break;
            }

            heap.set(index, parent);
            heap.set(parentIndex, item);
            index = parentIndex;

        }
    }

    private void siftDown() {
        int index = 0;
        int size = heap.size();

        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;
            System.out.println("------");
            System.out.println("left child " + leftChildIndex);
            System.out.println("right child " + rightChildIndex);
            System.out.println("size is " + size);
            System.out.println("printing out " + leftChildIndex);
            System.out.println(heap.get(leftChildIndex));
            if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex == index) {
                break;
            }

            T temp = heap.get(index);
            heap.set(index, heap.get(smallestChildIndex));
            heap.set(smallestChildIndex, temp);

            index = smallestChildIndex;
        }
    }

    public void printQueue() {
        heap.printList();

    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        // LinkedList<Integer> list = new LinkedList<>();
        // list.add(1);
        // list.add(3);
        // list.add(4);
        // list.add(6);
        // list.remove(2);
        // list.printList();
        PriorityQueueImpl<Integer> pq = new PriorityQueueImpl<>();
        pq.add(5);
        pq.add(3);
        pq.add(8);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        // pq.printQueue();

        // System.out.println(pq.poll());
        // while (!pq.isEmpty()) {
        // while (!pq.isEmpty()) {
        // System.out.println(pq.poll());
        // }
    }

}

class PatientArrivalData implements Comparable<PatientArrivalData> {
    int priorityLevel;
    LocalTime arrivalTime;
    String name="";

    public PatientArrivalData(int priorityLevel, LocalTime arrivalTime) {
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
    }

    public PatientArrivalData(String name,int priorityLevel, LocalTime arrivalTime) {
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(PatientArrivalData o) {
        return Integer.compare(this.priorityLevel, o.priorityLevel);
    }

}