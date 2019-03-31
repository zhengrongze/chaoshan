package com.mc.java程序语言设计.zhang25;

public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public void inorder() {

    }

    @Override
    public void postorder() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
