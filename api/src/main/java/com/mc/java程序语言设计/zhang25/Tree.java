package com.mc.java程序语言设计.zhang25;

public interface Tree<E> extends Iterable<E> {

    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);
    //中序
    void inorder();
    //前序
    void postorder();
    //后序
    void preorder();

    int getSize();

    boolean isEmpty();

}
