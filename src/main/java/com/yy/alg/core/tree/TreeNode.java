package com.yy.alg.core.tree;

import lombok.Data;

/**
 * Created by yinya on 2019/2/16.
 */
@Data
public class TreeNode<K extends Comparable<K>, V> {

    K key;
    V value;
    int childNum;

    TreeNode<K, V> left, right;

}
