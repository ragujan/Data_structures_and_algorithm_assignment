package com.rag_dsa.final_assignment.LinkedList;

public class LinkedList<T> {
    int size;
    LinkedListNode<T> head;

    public int size() {
        return countSize();
    }

    public void add(T newData) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(newData);

        size = 0;
        // if list is empty, add the new node as the head
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // traverse till the last node
        LinkedListNode<T> current = head;

        while (current.next != null) {
            size++;
            current = current.next;
        }
        current.next = newNode;

    }

    public void set(int index, T newData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        LinkedListNode<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                current.data = newData;
                return;
            }
            count++;
            current = current.next;
        }

        // If index is out of bounds
        if (current == null) {
            System.out.println("Index out of bounds.");
        }
    }

    public T remove(int index) {

        if (index >= size()) {
            return null;
        }
        if (head == null) {
            System.out.println("list is empty");
            return null;
        }
        // if the head node needs to be removed
        if (index == 0) {
            if (head.next != null) {
                // System.out.println("head next " + head.next.data);
                LinkedListNode<T> removedNode = head;
                head = head.next;
                return removedNode.data;
            }else{
                head = null;
                return null;
            }
        }

        LinkedListNode<T> current = head;
        LinkedListNode<T> prev = null;
        int count = 0;

        while (current != null) {
            if (count == index) {
                break;
            }
            prev = current;
            current = current.next;
            count++;
        }

        // if index is out of bound
        if (current == null) {
            System.out.println("Index out of bounds");
            return null;
        }

        // unlink the node
        if (current.next != null) {
            prev.next = current.next;
        } else {
            // System.out.println("prev is " + prev.data);
            prev.next = null;
        }

        return current.data;

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        LinkedListNode<T> starterNode = head;

        LinkedListNode<T> nodeTobeReturned = null;
        // Integer e = 33;

        int count = 0;
        LinkedListNode<T> currentNode = starterNode;

        while (currentNode != null) {
            // System.out.println("current node " + currentNode.data);
            // System.out.println("index " + count);
            if (count == index) {
                nodeTobeReturned = currentNode;
                break;
            }
            currentNode = currentNode.next;
            if (currentNode != null) {
                count++;
            }
        }
        if (nodeTobeReturned == null) {
            return null;
        }
        return nodeTobeReturned.data;

    }

    public LinkedListNode<T> getHeadNode() {
        return head;
    }

    public void printList() {
        LinkedListNode<T> node = head;
        System.out.println("----------");
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println("----------");
    }

    private int countSize() {
        int count = 0;
        LinkedListNode<T> node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(3);
        list.printList();
        System.out.println("removed at index 3 "+list.remove(3));
        list.printList();
        // System.out.println("size " + list.size());
        // System.out.println("delete process");
        // System.out.println("removed " + list.remove(0));
        // list.printList();
        // System.out.println("removed " + list.remove(0));
        // list.printList();
        // System.out.println("removed " + list.remove(0));
        // list.printList();
        // System.out.println("removed " + list.remove(0));
        // list.printList();
        // list.remove(0);
    }

    // public static void main(String[] args) {
    // LinkedList<Integer> llist = new LinkedList<Integer>();

    // llist.add(1);
    // llist.add(3);
    // llist.add(5);
    // llist.add(7);
    // llist.add(7);

    // llist.addByIndex(2, 10);
    // llist.printList();
    // System.out.println("Size is " + llist.getSize());
    // int index = 4;
    // System.out.println(index + " rd index is " + llist.get(index));

    // Integer first = llist.get(0);
    // Integer third = llist.get(2);

    // System.out.println(first.compareTo(third));
    // System.out.println(third.compareTo(first));
    // }

}
