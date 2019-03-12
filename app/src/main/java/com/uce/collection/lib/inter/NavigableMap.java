package com.uce.collection.lib.inter;

import java.lang.Comparable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedMap;

/**
 * author: banketree
 * created on: 2019/3/6 14:46
 * description:
 */
public interface NavigableMap<K,V> extends java.util.SortedMap<K,V> {

    java.util.Map.Entry<K,V> lowerEntry(K key);

    K lowerKey(K key);

    java.util.Map.Entry<K,V> floorEntry(K key);

    K floorKey(K key);

    java.util.Map.Entry<K,V> ceilingEntry(K key);

    K ceilingKey(K key);

    java.util.Map.Entry<K,V> higherEntry(K key);

    K higherKey(K key);

    java.util.Map.Entry<K,V> firstEntry();

    java.util.Map.Entry<K,V> lastEntry();

    java.util.Map.Entry<K,V> pollFirstEntry();

    Map.Entry<K,V> pollLastEntry();

    java.util.NavigableMap<K,V> descendingMap();

    java.util.NavigableSet<K> navigableKeySet();

    NavigableSet<K> descendingKeySet();

    java.util.NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                       K toKey, boolean toInclusive);

    java.util.NavigableMap<K,V> headMap(K toKey, boolean inclusive);

    java.util.NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);

    java.util.SortedMap<K,V> subMap(K fromKey, K toKey);

    java.util.SortedMap<K,V> headMap(K toKey);

    SortedMap<K,V> tailMap(K fromKey);
}
