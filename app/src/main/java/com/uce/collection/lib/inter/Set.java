package com.uce.collection.lib.inter;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * author: banketree
 * created on: 2019/3/6 14:31
 * description:
 */
public interface Set<E> extends java.util.Collection<E> {
    // Query Operations

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    // Modification Operations
    boolean add(E e);

    boolean remove(Object o);

    // Bulk Operations
    boolean containsAll(java.util.Collection<?> c);

    boolean addAll(java.util.Collection<? extends E> c);

    boolean retainAll(java.util.Collection<?> c);

    boolean removeAll(Collection<?> c);

    void clear();

    // Comparison and hashing
    boolean equals(Object o);

    int hashCode();

    @Override
    default java.util.Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, Spliterator.DISTINCT);
    }
}