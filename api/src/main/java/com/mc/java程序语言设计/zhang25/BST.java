package com.mc.java程序语言设计.zhang25;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 图元素对比的话，需要进行对比，所需元素继承Comparable接口
 * @param <E>
 */
public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;

    protected int size = 0;

    public BST() {
    }
    public BST(E [] objects){
        for (int i = 0; i < objects.length; i++){
            insert(objects[i]);
        }
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null){
            if(e.compareTo(current.element) < 0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }else
                return true;
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        if(root == null){
            root = createNewNode(e);
        }else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null){
                if(e.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }else if(e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }else
                    return false;
                if(e.compareTo(parent.element) < 0){
                    parent.left = createNewNode(e);
                }else {
                    parent.right = createNewNode(e);
                }
            }
        }
        size++;
        return true;
    }

    private TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean delete(E e) {
        //先判断是否为空
        //先判断元素是否存在
        //判断该元素是不是为子节点
        //是的话直接删除，如果不是的话，就需要删除以下的部分
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null){
            if(e.compareTo(current.element) < 0){
                parent = current;
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                parent = current;
                current = current.right;
            }else
                break;
        }
        if(current == null){
            return false;
        }
        if(current.left == null){
            if(parent == null){
                root = current.right;
            }else {
                if(e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {

        }
        return false;
    }


    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root){
        if(root == null)
            return;
        System.out.println(root.element + " ");
        postorder(root.left);
        postorder(root.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root){
        if(root == null)
            return;
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot(){
        return root;
    }

    public ArrayList<TreeNode<E>> path(E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null){
            list.add(current);
            if(e.compareTo(current.element) < 0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    public void clear(){
        root = null;
        size = 0;
    }

    /**
     * 存储二叉树的类
     * @param <E>
     */
    public static class TreeNode<E extends Comparable<E>>{
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
        }

    }

}
