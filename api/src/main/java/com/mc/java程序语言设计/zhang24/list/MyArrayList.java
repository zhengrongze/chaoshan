package com.mc.java程序语言设计.zhang24.list;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {

    public static final int INITIAL_CAPACITY = 16;

    private E [] data = (E[]) new Object[INITIAL_CAPACITY];

    public MyArrayList() {}

    protected MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }
    @Override
    public void add(int index, E e) {
        //如果需要，线性表数组大小翻倍
        ensureCapacity();
        if(index > size){
            throw new IndexOutOfBoundsException("越界了");
        }
        for(int i = size;i >= index; i--){
            data[i+1] = data[i];
            data[index] = e;
            size++;
        }
    }

    @Override
    public boolean contains(E e) {
        for(int i = 0; i < data.length; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++){
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 和add有点相似，可以了解一下
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        for (int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
            data[size-1] = null;
            size--;
        }
        return e;
    }

    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    public void trimToSize(){
        if(size != data.length){
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data,0,newData,0,size);
            data = newData;
        }
    }

    /**
     * 扩容数组的长度
     */
    public void ensureCapacity(){
        if(size > data.length){
            E [] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data,0,newData,0,size);
            data = newData;
        }
    }
    public void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index" + index + "out of bounds");
        }
    }
    private class ArrayListIterator implements Iterator<E>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
