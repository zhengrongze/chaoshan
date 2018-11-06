package com.mc.java程序语言设计.zhang23;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> {
    private List<E> list = new ArrayList<>();

    public Heap() {
    }
    public Heap(E [] object) {
        for (int i = 0; i < object.length; i++){
            add(object[i]);
        }
    }

    /**
     * 125页
     * @param newObject
     */
    public void add(E newObject){
        list.add(newObject);
        //当前的位置,也就是新添加元素的位置
        int currentIndex = list.size() - 1;
        //如果大于0的话，也就是不是根节点
        while (currentIndex > 0){
            //父节点的位置等于(当前节点的位置-1) / 2
            int parentIndex = (currentIndex -1) / 2;
            //如果当前节点大于父节点的话
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * 删除最大元素
     * @return
     * @throws Exception
     */
    public E remove() throws Exception {
        if(list.size() == 0){
            throw new Exception("堆内存为空");
        }
        //将底下的元素设置为根节点
        E removeObject = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(0,list.get(lastIndex));
        list.remove(lastIndex);

        int currentIndex = 0;
        while (currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if(leftChildIndex >= list.size())break;
            int maxIndex =leftChildIndex;
            if(rightChildIndex < list.size()){
                if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0){
                    maxIndex = rightChildIndex;
                }
            }
            if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                E temp = list.get(maxIndex);
                list.set(maxIndex,list.get(currentIndex));
                list.set(currentIndex,temp);
                currentIndex = maxIndex;
            }else {
                break;
            }
        }
        return removeObject;
    }

    public int getSize(){
        return list.size();
    }
}
