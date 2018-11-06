package com.mc.java程序语言设计.zhang24.list;

import java.util.List;

public interface MyList<E> extends Iterable<E>{
    void add(E e);

    void add(int index,E e);

    boolean contains(E e);

    void clear();

    E get(int index);

    boolean remove(E e);

    int indexOf(E e);

    int lastIndexOf(E e);

    boolean isEmpty();

    E remove(int index);

    Object set(int index,E e);

    int size();

}
