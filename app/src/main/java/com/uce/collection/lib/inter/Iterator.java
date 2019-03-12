package com.uce.collection.lib.inter;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * author: banketree
 * created on: 2019/3/6 14:11
 * description:
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
