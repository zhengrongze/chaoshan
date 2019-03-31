package com.mc.java程序语言设计.zhang24.linkedList;

/**
 *
 * @param <E>
 */
public class Node<E> {
    E element;
    Node<E> next;

    public Node(E e) {
        this.element = e;
    }
}
