package com.timneville.Lists;

import java.util.*;
import com.timneville.Node;

/**
 * Created by timneville on 21/6/17.
 */
public class SinglyLinkedListImpList<E> implements List<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedListImpList() {}


    /**
     * IMPLEMENT ME
     * */
    public SinglyLinkedListImpList(String[] elements) throws IllegalStateException {
        throw new IllegalStateException("String array was not passed in.");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns true if this list contains the specified element
    @Override
    public boolean contains(Object o) {
        Iterator<E> listIterator = iterator();
        while (listIterator.hasNext()) {
            E element = listIterator.next();
            if (element.equals(o)) {
                return true;
            }
        }
        return tail.getElement().equals(o); //false;

//        return indexOf(o) != -1;
    }

    //Returns an iterator over the elements in this list in proper sequence.
    @Override
    public Iterator<E> iterator() {
        if (isEmpty()) {
            return Collections.<E>emptyList().iterator();
        }

        return new Iterator<E>() {
            Node<E> currentNode;

            @Override
            public boolean hasNext() {
                if (currentNode == null) {
                    currentNode = head;
                }
                return currentNode.getNext() != null;
            }

            @Override
            public E next() {
                if(!hasNext()) { return tail.getElement(); }
                E answer = currentNode.getElement();
                currentNode = currentNode.getNext();
                return answer;
            }
        };
    }

    //Appends the specified element to the end of this list
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        return true;
    }

    //Inserts a new element at the specified index in the list, moving all subsequent elements one index later in the list
    //an error is thrown if index is not in range [0, size()]
    @Override
    public void add(int index, E element) {
        Node<E> currentNode = head;
        Node<E> newNode = new Node<>(element, null);
        Node<E> newNodeNext = null;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            if (index > size-1) throw new IndexOutOfBoundsException();
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();             //traverse the list to one before the index location
            }
            if (currentNode.getNext() != null) {
                newNodeNext = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setNext(newNodeNext);
        }
        size++;
    }
    
    @Override
    public boolean remove(Object o) {
        if (isEmpty()) { return false; }
        if (head.getElement().equals(o)) {
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = head;
            }
            return true;
        }

        Node<E> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getElement().equals(o)) {
                if (currentNode.getNext().getNext() != null) {
                    currentNode.setNext(currentNode.getNext().getNext());
                } else {
                    currentNode.setNext(null);
                    tail = currentNode;
                    return true;
                }
                size--;
            }
            currentNode = currentNode.getNext();             //traverse the list
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //Returns the element at the specified index in the list.
    //an error is thrown if index is not in range [0, size()-1]
    @Override
    public E get(int index) {
        if (isEmpty()) return null;
        if (index == 0) return head.getElement();
        if (index == size-1) return tail.getElement();

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    //Replaces the element at index with a different element
    //Error is thrown if index is not in range [0, size()-1]
    @Override
    public E set(int index, E element) {
        return null;
    }

    //Removes and returns the element at index, moving all subsequent elements one index earlier in the list
    //An error is thrown if inext is not in range [0, size()-1]
    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
                if (currentNode.getElement().equals(o)) {
                    return index;
                }
            index++;
            currentNode = currentNode.getNext();
        }
        // if o is not in the list return -1
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


}
