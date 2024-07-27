package com.rag_dsa.final_assignment.LinkedList;

public class LinkedList2<T> {
    LinkedListNode<T> head;

    // Method to insert a new node
    public void add(
            T data) {
        // Create a new node with given data
        LinkedListNode<T> new_node = new LinkedListNode<T>(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            LinkedListNode<T> last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

    }

    public int size() {
        LinkedListNode<T> currNode = head;

        int counter = 0;
        while (currNode != null) {
            currNode = currNode.next;
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T remove(int index) {
        // Store head node
        LinkedListNode<T> currNode = head, prev = null;
        T nodeTobeRemoved = null;
        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            head = currNode.next; // Changed head

            // Display the message
            System.out.println(
                    index + " position element deleted");

            // Return the updated List
            return nodeTobeRemoved;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required
                // position Unlink currNode from linked list
                nodeTobeRemoved = currNode.data;
                System.out.println("node to be removed data " + nodeTobeRemoved);

                if (currNode.next == null) {
                    break;
                } else {
                    System.out.println(currNode.next.data);
                    System.out.println("came here instead ");
                    prev.next = currNode.next;

                }

                // Display the message
                System.out.println(
                        index + " position element deleted");
                break;
            } else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(
                    index + " position element not found");
        }
        return nodeTobeRemoved;

    }

    public void set(int index, T newValue) {
        // Store head node
        LinkedListNode<T> currNode = head;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            head.data = newValue; // Changed head

            // Display the message
            System.out.println(
                    index + " position element deleted");

            // Return the updated List
            // return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required
                // position Unlink currNode from linked list
                currNode.data = newValue;

                // Display the message
                System.out.println(
                        index + " position element deleted");
                break;
            }
            currNode = currNode.next;
            counter++;
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(
                    index + " position element not found");
        }

    }

    public T get(int index) {
        // Store head node
        LinkedListNode<T> currNode = head;
        T dataToBeReturned = null;
        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            dataToBeReturned = head.data;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                dataToBeReturned = currNode.data;
                break;
            }
            currNode = currNode.next;
            counter++;
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(
                    index + " position element not found");
        }
        return dataToBeReturned;

    }

    public void printList() {
        LinkedListNode<T> currNode = head;

        System.out.print("\nLinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        LinkedList2<Integer> list = new LinkedList2<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.printList();
        // list.remove(1);
        // list.printList();
        // System.out.println("size " + list.size());
        // list.set(0, 8);
        // list.printList();
        // System.out.println("get " + list.get(0));
        // System.out.println("get " + list.get(1));
        // list.remove(2);
        System.out.println("=++++++======");
        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        System.out.println("size "+list.size());
        list.printList();
    }
}
