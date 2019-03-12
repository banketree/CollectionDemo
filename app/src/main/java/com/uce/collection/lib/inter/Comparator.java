package com.uce.collection.lib.inter;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * author: banketree
 * created on: 2019/3/6 14:44
 * description:
 */
@FunctionalInterface
public interface Comparator<T> {

    int compare(T o1, T o2);

    boolean equals(Object obj);

    default java.util.Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }

    default java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return (java.util.Comparator<T> & Serializable) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    default <U> java.util.Comparator<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor,
            java.util.Comparator<? super U> keyComparator)
    {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    default <U extends java.lang.Comparable<? super U>> java.util.Comparator<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        return thenComparing(comparing(keyExtractor));
    }

    default java.util.Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    default java.util.Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    default java.util.Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }

    @SuppressWarnings("unchecked")
    public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> naturalOrder() {
        return (java.util.Comparator<T>) Comparators.NaturalOrderComparator.INSTANCE;
    }

    public static <T> java.util.Comparator<T> nullsFirst(java.util.Comparator<? super T> comparator) {
        return new Comparators.NullComparator<>(true, comparator);
    }

    public static <T> java.util.Comparator<T> nullsLast(java.util.Comparator<? super T> comparator) {
        return new Comparators.NullComparator<>(false, comparator);
    }

    public static <T, U> java.util.Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            java.util.Comparator<? super U> keyComparator)
    {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (java.util.Comparator<T> & Serializable)
                (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                        keyExtractor.apply(c2));
    }

    public static <T, U extends Comparable<? super U>> java.util.Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (java.util.Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static <T> java.util.Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (java.util.Comparator<T> & Serializable)
                (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }

    public static <T> java.util.Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (java.util.Comparator<T> & Serializable)
                (c1, c2) -> Long.compare(keyExtractor.applyAsLong(c1), keyExtractor.applyAsLong(c2));
    }

    public static<T> java.util.Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (java.util.Comparator<T> & Serializable)
                (c1, c2) -> Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
    }
}
