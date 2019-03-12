package com.uce.collection.lib;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * author: banketree
 * created on: 2019/3/6 14:58
 * description:
 */
public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected AbstractSequentialList() {
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with <tt>listIterator(index)</tt>).  Then, it gets
     * the element using <tt>ListIterator.next</tt> and returns it.
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        try {
            return listIterator(index).next();
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with <tt>listIterator(index)</tt>).  Then, it gets
     * the current element using <tt>ListIterator.next</tt> and replaces it
     * with <tt>ListIterator.set</tt>.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the list iterator does not
     * implement the <tt>set</tt> operation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E set(int index, E element) {
        try {
            ListIterator<E> e = listIterator(index);
            E oldVal = e.next();
            e.set(element);
            return oldVal;
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with <tt>listIterator(index)</tt>).  Then, it
     * inserts the specified element with <tt>ListIterator.add</tt>.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the list iterator does not
     * implement the <tt>add</tt> operation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public void add(int index, E element) {
        try {
            listIterator(index).add(element);
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * <p>This implementation first gets a list iterator pointing to the
     * indexed element (with <tt>listIterator(index)</tt>).  Then, it removes
     * the element with <tt>ListIterator.remove</tt>.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the list iterator does not
     * implement the <tt>remove</tt> operation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public E remove(int index) {
        try {
            ListIterator<E> e = listIterator(index);
            E outCast = e.next();
            e.remove();
            return outCast;
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }


    // Bulk Operations

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * <p>This implementation gets an iterator over the specified collection and
     * a list iterator over this list pointing to the indexed element (with
     * <tt>listIterator(index)</tt>).  Then, it iterates over the specified
     * collection, inserting the elements obtained from the iterator into this
     * list, one at a time, using <tt>ListIterator.add</tt> followed by
     * <tt>ListIterator.next</tt> (to skip over the added element).
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the list iterator returned by
     * the <tt>listIterator</tt> method does not implement the <tt>add</tt>
     * operation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            boolean modified = false;
            ListIterator<E> e1 = listIterator(index);
            Iterator<? extends E> e2 = c.iterator();
            while (e2.hasNext()) {
                e1.add(e2.next());
                modified = true;
            }
            return modified;
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }


    // Iterators

    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).<p>
     *
     * This implementation merely returns a list iterator over the list.
     *
     * @return an iterator over the elements in this list (in proper sequence)
     */
    public Iterator<E> iterator() {
        return listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @param  index index of first element to be returned from the list
     *         iterator (by a call to the <code>next</code> method)
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public abstract ListIterator<E> listIterator(int index);
}
