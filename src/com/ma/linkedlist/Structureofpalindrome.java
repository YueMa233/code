package com.ma.linkedlist;

/**
 * 题目：
 * 给定一个链表的头结点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1,返回true。
 * 1->2->2->,1返回true。
 * 15->6->15,返回true。
 * 1-2->3,返回false。
 */

import java.util.Stack;

/**
 * 解答：
 * 利用栈结构，从左到右遍历链表，遍历的过程中把每个节点依次压入栈中。因为栈是先进后出的，所以遍历完成后从栈顶到
 * 栈的节点值顺序会与原链表从左到右的值是顺序反过来的。那么如果一个链表是回文结构的话逆序之后值出现的顺序是一样的
 * 如果不是回文结构，顺序就肯定对不上。
 */

public class Structureofpalindrome {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static boolean isPalindrom(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        System.out.println(isPalindrom(head));
    }
}
