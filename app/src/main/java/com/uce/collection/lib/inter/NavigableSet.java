package com.uce.collection.lib.inter;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * author: banketree
 * created on: 2019/3/6 14:43
 * description:
 */
public interface NavigableSet<E> extends java.util.SortedSet<E> {

    E lower(E e);

    E floor(E e);

    E ceiling(E e);

    E higher(E e);

    E pollFirst();

    E pollLast();

    java.util.Iterator<E> iterator();

    java.util.NavigableSet<E> descendingSet();

    Iterator<E> descendingIterator();

    java.util.NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
                                     E toElement, boolean toInclusive);

    java.util.NavigableSet<E> headSet(E toElement, boolean inclusive);

    java.util.NavigableSet<E> tailSet(E fromElement, boolean inclusive);

    java.util.SortedSet<E> subSet(E fromElement, E toElement);

    java.util.SortedSet<E> headSet(E toElement);

    SortedSet<E> tailSet(E fromElement);
}

