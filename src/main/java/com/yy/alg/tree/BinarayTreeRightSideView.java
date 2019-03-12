package com.yy.alg.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yinya on 2019/2/16.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 *
 *          1，模型。f(n) 与 f(n-1)的关系
 *          2，单次f(n)与全局关系
 *          3, 结束条件
 */
public class BinarayTreeRightSideView {

    TreeNode root;

    int currHeight = Integer.MIN_VALUE;

    @Data
    static class TreeNode {
        int value;

        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "" + value;
        }
    }

    public List<TreeNode> solution(TreeNode x) {

        List<TreeNode> list = new LinkedList<TreeNode>();
        currHeight = Integer.MIN_VALUE;

        dfs(x, 0, list);

        return list;
    }

    private void dfs(TreeNode x, int height, List<TreeNode> list) {
        if (x == null) return;
        if(height > currHeight){
            list.add(x);
            currHeight = height;
        }

        dfs(x.right, height + 1, list);
        dfs(x.left, height + 1, list);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(7);
        root.right.left.left.right = new TreeNode(10);
        root.right.left.left.left = new TreeNode(7);

        BinarayTreeRightSideView btrsv = new BinarayTreeRightSideView();
        btrsv.root = root;

        List<TreeNode> list = btrsv.solution(root);

        System.out.println(list);

    }

}
