package com.yy.alg.linklist;

import lombok.Data;

/**
 * Created by yinya on 2019/2/16.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {



    public static Node solution(Node root) {
        if(null == root || root.next == null){
            return root;
        }
        Node newHead = root.next;
        Node curr = root.next;
        Node pre = root;
        Node prepre = new Node(-1);//dummy node
        while(curr != null){
            pre.next = curr.next;
            curr.next = pre;
            prepre.next = curr;

            if(pre.next != null){
                prepre = pre;
                curr = pre.next.next;
                pre = pre.next;

            }else {
                curr = null;
            }
        }

        return newHead;
    }



    public static void main(String[] args) {
        Node first = new Node(1), second = new Node(2), third = new Node(3), fourth = new Node(4);
        first.next = second;
        second.next = third;
        third.next = fourth;

        Node list = solution(first);

        printNode(list);
    }

    private static void printNode(Node list) {
        if(null == list) return;
        while(list != null){
            System.out.println(list.value);
            list = list.next;
        }
    }
}
