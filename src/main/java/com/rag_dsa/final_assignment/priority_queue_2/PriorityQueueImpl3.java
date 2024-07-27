package com.rag_dsa.final_assignment.priority_queue_2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.rag_dsa.final_assignment.LinkedList.LinkedList;
import com.rag_dsa.final_assignment.LinkedList.LinkedList2;


public class PriorityQueueImpl3<T extends Comparable<T>> {
    private LinkedList<T> heap;

    public PriorityQueueImpl3() {
        heap = new LinkedList<>();
    }

    public void add(T item) {
        heap.add(item);
        siftUp();
    }

    public T poll() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }

        T item = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            siftDown();
        }

        return item;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
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

    public void printQueue() {
        heap.printList();
    }

    private void siftDown() {
        int index = 0;
        // int size = heap.size();

        while (index < heap.size()) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;


            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
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

    public static void main(String[] args) {
        PriorityQueueImpl3<Integer> pq = new PriorityQueueImpl3<>();

        pq.add(5);
        pq.add(3);
        pq.add(8);
        pq.add(1);
        // pq.printQueue();

        System.out.println("------");
        // System.out.println("removed last element "+pq.poll());
        // System.out.println("removed last element "+pq.poll());
        // System.out.println("removed last element "+pq.poll());
        // System.out.println("removed last element "+pq.poll());
        pq.printQueue();
        while (!pq.isEmpty()) {
            Integer polledData = pq.poll();
            System.out.println(polledData );
        }
        // pq.printQueue();
        PriorityQueueImpl3<PatientArrivalData> patients = new PriorityQueueImpl3<>();
        patients.add(new PatientArrivalData("p1",3, LocalTime.of(9, 00)));
        patients.add(new PatientArrivalData("p2",1, LocalTime.of(9, 10)));
        patients.add(new PatientArrivalData("p3",2, LocalTime.of(9,30)));
        patients.add(new PatientArrivalData("p4",4, LocalTime.of(10, 00)));
        patients.add(new PatientArrivalData("p5",1, LocalTime.of(10, 30)));
        System.out.println("============");
        while (!patients.isEmpty()) {
            PatientArrivalData polledData = patients.poll();
            System.out.println(polledData.priorityLevel+" "+polledData.getName());
        }


    }
}
