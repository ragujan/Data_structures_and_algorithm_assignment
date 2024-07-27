package com.rag_dsa.final_assignment.priority_queue;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.rag_dsa.final_assignment.LinkedList.LinkedList;
import com.rag_dsa.final_assignment.LinkedList.LinkedListNode;

public class PriorityQueueImpl {

    ArrayList<Integer> myIntegerList = new java.util.ArrayList<Integer>();
    LinkedList<PatientArrivalData> list = new LinkedList<>();

    public void heapify(LinkedList<PatientArrivalData> list, int index) {
        int size = list.size();

        // process to find the largest amont root, left child and right child
        int largestIndex = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // left index should be smaller than list size, and left index of list should be
        // greater than
        // the largest index of the list

        // right index should be smaller than list size
        // right index of the list value should be greater than largest index's list
        // value
        if (leftIndex < size && list.get(leftIndex).compareTo(list.get(largestIndex)) > 1) {
            largestIndex = leftIndex;
        }

        if (rightIndex < size && list.get(rightIndex).compareTo(list.get(largestIndex)) > 1) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            PatientArrivalData tempValue = list.get(largestIndex);
            list.set(largestIndex, list.get(index));
            list.set(index, tempValue);
            heapify(list, largestIndex);
        }
    }

    public void heapify(int index) {
        int size = myIntegerList.size();

        // process to find the largest amont root, left child and right child
        int largestIndex = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // left index should be smaller than list size, and left index of list should be
        // greater than
        // the largest index of the list

        // right index should be smaller than list size
        // right index of the list value should be greater than largest index's list
        // value
        // if (leftIndex < size) {
        // System.out.println("leftIndex < size ");
        // System.out.println("list.get(leftIndex).compareTo(list.get(largestIndex)) "
        // + myIntegerList.get(leftIndex).compareTo(myIntegerList.get(largestIndex)));
        // }
        // if (rightIndex < size) {
        // System.out.println("rightINdex < size ");
        // System.out.println("list.get(rightIndex).compareTo(list.get(largestIndex)) "
        // + myIntegerList.get(rightIndex).compareTo(myIntegerList.get(largestIndex)));
        // }
        // if (leftIndex < size &&
        // myIntegerList.get(leftIndex).compareTo(myIntegerList.get(largestIndex)) > 1)
        // {
        if (leftIndex < size && (myIntegerList.get(leftIndex) > myIntegerList.get(largestIndex))) {
            largestIndex = leftIndex;
        }

        // if (rightIndex < size &&
        // myIntegerList.get(rightIndex).compareTo(myIntegerList.get(largestIndex)) > 1)
        // {
        if (rightIndex < size && myIntegerList.get(rightIndex) > myIntegerList.get(largestIndex)) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            Integer tempValue = myIntegerList.get(largestIndex);
            myIntegerList.add(largestIndex, myIntegerList.get(index));
            myIntegerList.add(index, tempValue);
            System.out.println("going here");
            heapify(largestIndex);
        }
    }

    void heapify2(int i) {
        int size = myIntegerList.size();
        // Find the largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && myIntegerList.get(l) > myIntegerList.get(largest))
            largest = l;
        if (r < size && myIntegerList.get(r) > myIntegerList.get(largest))
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = myIntegerList.get(largest);
            myIntegerList.set(largest, myIntegerList.get(i));
            myIntegerList.set(i, temp);

            heapify2(largest);
        }
    }

    void insert(PatientArrivalData newArrivalData) {

        int size = list.size();
        if (size == 0) {
            list.add(newArrivalData);
        } else {
            list.add(newArrivalData);

            for (int i = size / 2 - 1; i >= 0; i--) {
                System.out.println("heapfiying");
                heapify(list, i);
            }
        }
    }

    void insert(Integer newData) {
        int size = myIntegerList.size();
        if (size == 0) {
            myIntegerList.add(newData);
        } else {
            myIntegerList.add(newData);

            for (int i = size / 2 - 1; i >= 0; i--) {
                System.out.println("heapfiying");
                heapify2(i);
            }
        }
    }

    void deleteNode(int num) {
        int size = myIntegerList.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == myIntegerList.get(i))
                break;
        }

        int temp = myIntegerList.get(i);
        myIntegerList.set(i, myIntegerList.get(size - 1));
        myIntegerList.set(size - 1, temp);

        myIntegerList.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heapify2(j);
        }
    }

    public void printLinkedList(LinkedList<PatientArrivalData> list) {
        LinkedListNode<PatientArrivalData> currentNode = list.getHeadNode();
        while (currentNode != null) {
            // node = node.ne;
            System.out.println("current node data " + currentNode.data.priorityLevel + " time is "
                    + currentNode.data.getArrivalTime());
            currentNode = currentNode.next;
        }
    }

    public void printIntegerList() {
        System.out.println("print out the elements ");
        myIntegerList.forEach(e -> System.out.println("e is " + e));
    }

    public static void main(String[] args) {
        PriorityQueueImpl priorityQueueImpl = new PriorityQueueImpl();
        priorityQueueImpl.insert(5);
        priorityQueueImpl.insert(3);
        priorityQueueImpl.insert(8);
        priorityQueueImpl.insert(1);
        // priorityQueueImpl.insert(1);
        // priorityQueueImpl.insert(4);
        // priorityQueueImpl.insert(2);
        // priorityQueueImpl.insert(6);
        // priorityQueueImpl.insert(7);
        // priorityQueueImpl.insert(5);
        // priorityQueueImpl.insert(3);
        priorityQueueImpl.printIntegerList();

        // LinkedList<PatientArrivalData> linkedList = new
        // LinkedList<PatientArrivalData>();

        // linkedList.add(new PatientArrivalData(4, LocalTime.of(9, 30)));
        // linkedList.add(new PatientArrivalData(3, LocalTime.of(9, 0)));
        // // linkedList.add(new PatientArrivalData(2, LocalTime.of(8, 45)));
        // priorityQueueImpl.insert(linkedList, new PatientArrivalData(2,
        // LocalTime.of(8, 45)));
        // priorityQueueImpl.insert(linkedList, new PatientArrivalData(4,
        // LocalTime.of(8, 45)));

        // priorityQueueImpl.printLinkedList(linkedList);
    }

}

class PatientArrivalData implements Comparable<PatientArrivalData> {
    int priorityLevel;
    LocalTime arrivalTime;

    public PatientArrivalData(int priorityLevel, LocalTime arrivalTime) {
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
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
