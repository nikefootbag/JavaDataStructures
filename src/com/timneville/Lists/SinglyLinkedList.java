package com.timneville.Lists;

import java.util.List;
import com.timneville.Node;

/**
 * Created by timneville on 31/5/17.
 */
public class SinglyLinkedList<E> /*implements List<E>*/ {
    //instance variables of SSL
    private Node<E> head = null;	//head and tail initially null.
    private Node<E> tail = null;
    private int size = 0;

    //constructor for SSL
    public SinglyLinkedList() {} 	//Construct initially empty list.

    //access methods
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E getFirst() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    //update methods
    public void addFirst(E element) {
        //create a new node & reference newNode to the current head
        head = new Node<>(element, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        //create a new node, next reference is null because your adding to the end.
        Node<E> newNode = new Node<>(element, null);
        //check if list empty as you can't make current tail ref newNode if no current tail.
        //make the current tail reference the newNode
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        //make newnode the tail
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        //Indicate the new head; then remove the prior head and return it.
        if (isEmpty()) { return null; }
        E removedElement = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = head;
        }
        return removedElement;
    }

    public E removeWithValue(E value) {
        if (isEmpty()) { return null; }
        if (head.getElement().equals(value)) {              //if head is the one to be deleted
            return removeFirst();
        }
        E removedElement = null;
        Node<E> currentNode = head;                        //starting at the head

        while (currentNode.getNext() != null) {              //while not at the tail of the list
            if (currentNode.getNext().getElement().equals(value)) {	//if the next value is the one you want to delete,
                removedElement = currentNode.getNext().getElement();
                if (currentNode.getNext().getNext() != null) {
                    currentNode.setNext(currentNode.getNext().getNext());//then "walk around" the next element, cutting it out by setting current.next reference to next.next;
                } else {
                    currentNode.setNext(null);
                    tail = currentNode;
                    return removedElement;
                }
                size--;
            }
            currentNode = currentNode.getNext();             //traverse the list
        }
        return removedElement;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}

































