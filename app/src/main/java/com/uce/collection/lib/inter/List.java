package com.uce.collection.lib.inter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.UnaryOperator;

/**
 * author: banketree
 * created on: 2019/3/6 14:28
 * description:
 */
public interface List<E> extends java.util.Collection<E> {
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

    // Bulk Modification Operations
    boolean containsAll(java.util.Collection<?> c);

    boolean addAll(java.util.Collection<? extends E> c);

    boolean addAll(int index, java.util.Collection<? extends E> c);

    boolean removeAll(java.util.Collection<?> c);

    boolean retainAll(Collection<?> c);

    default void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final ListIterator<E> li = this.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }

    // Android-changed: Warn about Collections.sort() being built on top
    // of List.sort() rather than the other way round when targeting an
    // API version > 25.
    @SuppressWarnings({"unchecked", "rawtypes"})
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    void clear();

    // Comparison and hashing
    boolean equals(Object o);

    int hashCode();

    // Positional Access Operations

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    // Search Operations
    int indexOf(Object o);

    int lastIndexOf(Object o);

    // List Iterators
    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    // View
    java.util.List<E> subList(int fromIndex, int toIndex);

    @Override
    default java.util.Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, Spliterator.ORDERED);
    }
}
