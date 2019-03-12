package com.yy.alg.core.tree;

/**
 * Created by yinya on 2019/2/16.
 */
public interface BTree<K extends Comparable<K>, V> extends Tree {

    V put(K key, V v);

    V delete(K key);

    V search(K key);

    int height();

    int size();

    void preOrder();

    void minOrder();

    void postOrder();
}
