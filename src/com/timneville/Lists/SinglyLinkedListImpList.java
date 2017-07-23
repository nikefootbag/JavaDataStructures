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
    public SinglyLinkedListImpList(E[] elements) throws IllegalStateException {
        //throw new IllegalStateException("String array was not passed in.");
        addAll(Arrays.asList(elements));
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
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element.equals(o)) {
                return true;
            }
        }
        return tail.getElement().equals(o); //tail was getting missed so final check is if tail is equal to object passed in

//        return indexOf(o) != -1;
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
    public boolean remove(Object object) {
        if (isEmpty()) { return false; }
        if (head.getElement().equals(object)) {
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = head;
            }
            return true;
        }

        Node<E> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getElement().equals(object)) {
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
    public boolean containsAll(Collection<?> collection) {

        Iterator<?> specifiedCollection = collection.iterator();
        while (specifiedCollection.hasNext()) {
            Object element = specifiedCollection.next();
            if (this.contains(element)) {
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
           add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        for (E element : collection) {
            add(index, element);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean didRemove = false;

        Iterator<E> collectionIterator = (Iterator<E>) collection.iterator();
        while (collectionIterator.hasNext()) {
            Object currentElement = collectionIterator.next();
            if (indexOf(currentElement) != -1) {
                remove(currentElement);
                didRemove = true;
            }
        }
        return didRemove;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
        if (isEmpty()) return null;
        if (index > size()-1) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        E removedElement;
        if (index == 0) {
            removedElement = head.getElement();
            head.setElement(element);
            return removedElement;
        }

        Node<E> currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.getNext();
        }
        removedElement = currentNode.getElement();
        currentNode.setElement(element);
        return removedElement;
    }

    //Removes and returns the element at index, moving all subsequent elements one index earlier in the list
    //An error is thrown if index is not in range [0, size()-1]
    @Override
    public E remove(int index) {
        if (isEmpty()) return null;
        if (index > size()-1) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        E removedElement;
        if (index == 0) {
            removedElement = head.getElement();
            head = head.getNext();
            size--;
            return removedElement;
        }

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        removedElement = currentNode.getNext().getElement();
        currentNode.setNext(currentNode.getNext());
        size--;
        return removedElement;
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
    public int lastIndexOf(Object object) {
        if (!this.contains(object)) {
            return -1;
        }
        int index = 0;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(object)) {
                index++;
            }
            currentNode = currentNode.getNext();
        }
        // if o is not in the list return -1
        return index;
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

    @Override
    public ListIterator<E> listIterator() {
        if (isEmpty()) {
            return Collections.<E>emptyList().listIterator();
        }

        return new ListIterator<E>() {
            private Node<E> prevNode;
            private Node<E> nextNode;
            private int nextIndex = 0;
            private int prevIndex = -1;
            private Node<E> currentlySelectedNode;

            /** Inserts element into the list before implicit cursor. A call to previous would return the new element
             * (i.e. this call increments nextIndex and prevIndex */
            @Override
            public void add(E element) {
                if (isEmpty()) {
                    head = new Node<E>(element, null);
                    tail = head;
                    prevNode = head;
                    nextNode = null;
                } else {
                    prevNode.setNext(new Node<E>(element, nextNode));
                }
                size++;
                nextIndex++;
                prevIndex++;
            }

            /** Returns true if this list iterator has more elements when traversing the list in the forward direction.
             * (In other words, returns true if next() would return an element rather than throwing an exception.) */
            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            /** Returns true if this list iterator has more elements when traversing the list in the reverse direction.
             * (In other words, returns true if previous() would return an element rather than throwing an exception.) */
            @Override
            public boolean hasPrevious() {
                return prevNode != null;
            }

            /** Returns the next element in the list and advances the cursor position. */
            @Override
            public E next() throws NoSuchElementException {
                if (nextNode == null) {
                    throw new NoSuchElementException("No next element");
                }

                currentlySelectedNode = nextNode;   //for use by the remove() or set() methods
                E answer = currentlySelectedNode.getElement();
                prevNode = currentlySelectedNode;
                if (currentlySelectedNode.getNext() != null) {
                    nextNode = nextNode.getNext();
                } else {
                    nextNode = null;
                }

                nextIndex++;
                prevIndex++;
                return answer;
            }

            /** Returns the index of the element that would be returned by a subsequent call to next().
             * (Returns list size if the list iterator is at the end of the list.) */
            @Override
            public int nextIndex() {
                if (nextIndex > size()) {
                    return size();
                } else {
                    return nextIndex;
                }
            }

            /** Returns the previous element in the list and moves the cursor position backwards. */
            @Override
            public E previous() throws NoSuchElementException {
                if (prevIndex == -1) {
                    throw new NoSuchElementException("No previous element");
                }

                //because this is singly linked list, and we only have reference to the previousNode
                //so will need to move from head to the index-1 in order to get prevNode reference.
                Node<E> currentNode = head;
                for (int i = 0; i < prevIndex; i++) {
                    currentNode = currentNode.getNext();
                }
                currentlySelectedNode = currentNode.getNext();   //for use by the remove() or set() methods
                E answer = currentlySelectedNode.getNext().getElement();    //get prev element to return;
                prevNode = currentNode;                  //set prevNode to currentNode (which is prevIndex-1)
                nextNode = currentNode.getNext();        //set nextNode to currentNode.next (which is prevIndex)

                nextIndex--;
                prevIndex--;

                return answer;
            }

            /** Returns the index of the element that would be returned by a subsequent call to previous().
             * (Returns -1 if the list iterator is at the beginning of the list.) */
            @Override
            public int previousIndex() {
                return prevIndex;
            }

            /** Removes from the list the last element that was returned by next() or previous() (optional operation).
             * This call can only be made once per call to next or previous.
             * It can be made only if add(E) has not been called after the last call to next or previous. */
            @Override
            public void remove() throws IllegalStateException {
                if (currentlySelectedNode == null) {
                    throw new IllegalStateException("next or previous have not been called, or removed/add has been called since last next/previous call");
                }

                if (currentlySelectedNode == head) {
                    head = head.getNext();
                }

                prevNode.setNext(nextNode.getNext());

                currentlySelectedNode = null;
                size--;
            }

            /**  */
            @Override
            public void set(E element) throws IllegalStateException {
                if (currentlySelectedNode == null) {
                    throw new IllegalStateException("next or previous have not been called, or removed/add has been called since last next/previous call");
                }

                currentlySelectedNode.setElement(element);

                currentlySelectedNode = null;
            }
        };
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
    public Object[] toArray() {
        Object[] returnedArray = new Object[size()];
        Node currentNode = head;
        for (Object element: returnedArray) {
            element = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        return returnedArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


}
