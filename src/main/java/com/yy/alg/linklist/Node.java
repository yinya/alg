package com.yy.alg.linklist;

import lombok.Data;

public class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }
}