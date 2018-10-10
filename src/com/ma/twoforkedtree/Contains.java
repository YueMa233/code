package com.ma.twoforkedtree;

/**
 * 判断t1树是否包含t2树的全部拓扑结构
 */
public class Contains {
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public boolean contains(Node t1, Node t2){
        return check(t1,t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }
    public boolean check(Node h, Node t2){
        if(t2 == null){
            return true;
        }
        if(h == null || h.value != t2.value){
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
