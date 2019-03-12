package com.uce.collection.lib.Queue;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * author: banketree
 * created on: 2019/3/12 9:42
 * description:
 */
public interface BlockingQueue<E> extends Queue<E> {

    boolean add(E e);

    boolean offer(E e);

    void put(E e) throws InterruptedException;

    boolean offer(E e, long timeout, TimeUnit unit)
            throws InterruptedException;

    E take() throws InterruptedException;

    E poll(long timeout, TimeUnit unit)
            throws InterruptedException;

    int remainingCapacity();

    boolean remove(Object o);

    boolean contains(Object o);

    int drainTo(Collection<? super E> c);

    int drainTo(Collection<? super E> c, int maxElements);
}
