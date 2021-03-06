package com.timneville.Lists;

/**
 * Created by timneville on 15/8/17.
 */
public interface PositionalList<E> {
    int size();

    boolean isEmpty();

    Position<E> first();

    Position<E> last();

    Position<E> before(Position<E> position) throws IllegalArgumentException;

    Position<E> after(Position<E> position) throws IllegalArgumentException;

    Position<E> addFirst(E element);

    Position<E> addLast(E element);

    Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException;

    Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException;

    E set(Position<E> position, E element) throws IllegalArgumentException;

    E remove(Position<E> position) throws  IllegalArgumentException;
}
