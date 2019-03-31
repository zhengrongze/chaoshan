package com.mc.java程序语言设计.zhang24.linkedList;

import com.mc.java程序语言设计.zhang24.list.MyAbstractList;

import java.util.Iterator;

public class MyLinkedLIst<E> extends MyAbstractList<E> {

    private Node<E> head,tail;

    public MyLinkedLIst() {
    }

    public MyLinkedLIst(E[] objects) {
        super(objects);
    }

    public E getFrist(){
        return size == 0 ? null : head.element;
    }

    public E getLast(){
        return size == 0 ? null : tail.element;
    }
    public void addFrist(E e){
        Node<E> newNode = new Node<>(e);
        //如果头等于空直接放头部
        if(head == null){
            head = newNode;
            //把原先的头放到插入元素的节点上面
        }else {
            newNode.next = head;
        }
        //如果没有尾节点的话，头就是尾
        if(tail == null){
            tail = head;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(tail == null){
            head = tail = newNode;
        }else {
            //链表尾节点的next装的是newNode
            tail.next = newNode;
            //并且将newNode变成尾节点
            tail = tail.next;
        }
        size++;
    }
    public E removeFirst(){
        return null;
    }
    public E removeLast(){
        return null;
    }

    @Override
    public boolean remove(E e) {
        return super.remove(e);
    }

    @Override
    public void add(int index, E e) {
        if(index == 0){
            addFrist(e);
        }else if(index == size ){
            addLast(e);
        }else if(index > size){
            throw new IndexOutOfBoundsException("插入的位置大于链表的长度");
        }else {
            //TODO  这里不是很懂逻辑
            Node<E> current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
                Node<E> temp = current.next;
                current.next = new Node<>(e);
                current.next.next = temp;
                size++;
            }
        }
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i< size; i++){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Object set(int index, E e) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
