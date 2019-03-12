package com.yy.alg.core.tree.impl;


import com.yy.alg.core.tree.BTree;
import com.yy.alg.core.tree.TreeNode;

/**
 * Created by yinya on 2019/2/16.
 */
public class BTreeImpl<K extends Comparable<K>, V> implements BTree<K, V> {

    TreeNode<K, V> root;

    int treeHeight;

    public BTreeImpl(){
        randomConstruct();
    }

    private void randomConstruct() {

        TreeNode<K, V> root ;

    }

    public V put(K key, V v) {
        return null;
    }

    public V delete(K key) {
        return null;
    }

    public V search(K key) {
        return null;
    }

    public int height() {
        return treeHeight;
    }

    private int size(TreeNode<K, V> root) {
        if (null == root) return 0;

        return root.getChildNum();
    }

    public int size() {
        return size(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<K, V> root) {
        if(null == root) return;

        System.out.println(root.getValue());

        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void minOrder() {

        minOrder(root);

    }

    private void minOrder(TreeNode<K, V> root) {
        if(null == root) return;

        minOrder(root.getLeft());
        System.out.println(root.getValue());
        minOrder(root.getRight());
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<K, V> root) {
        if(null == root) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue());
    }
}
