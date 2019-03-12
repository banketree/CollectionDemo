package com.uce.collection.lib.inter;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * author: banketree
 * created on: 2019/3/6 14:37
 * description:
 */
public interface SortedMap<K,V> extends java.util.Map<K,V> {

    Comparator<? super K> comparator();

    java.util.SortedMap<K,V> subMap(K fromKey, K toKey);

    java.util.SortedMap<K,V> headMap(K toKey);

    java.util.SortedMap<K,V> tailMap(K fromKey);

    K firstKey();

    K lastKey();

    java.util.Set<K> keySet();

    Collection<V> values();

    Set<Entry<K, V>> entrySet();
}
