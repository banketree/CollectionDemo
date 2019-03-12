package com.uce.collection.lib.inter;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * author: banketree
 * created on: 2019/3/6 14:38
 * description:
 */
public interface SortedSet<E> extends Set<E> {

    Comparator<? super E> comparator();

    java.util.SortedSet<E> subSet(E fromElement, E toElement);

    java.util.SortedSet<E> headSet(E toElement);

    java.util.SortedSet<E> tailSet(E fromElement);

    E first();

    E last();

    @Override
    default java.util.Spliterator<E> spliterator() {
        return new Spliterators.IteratorSpliterator<E>(
                this, java.util.Spliterator.DISTINCT | java.util.Spliterator.SORTED | Spliterator.ORDERED) {
            @Override
            public Comparator<? super E> getComparator() {
                return java.util.SortedSet.this.comparator();
            }
        };
    }
}
