package com.thinksee.jzoffer;

import java.util.List;
import java.util.Stack;

/**
 * @author thinksee
 * @since 2019-5-28
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class J05PrintList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
        }
    }

    /**
     * 链表的前序插入：
     * 数组 1 2 3 4 5 6
     * 链表 6-5-4-3-2-1
     * @param head
     * @param nums
     * @return
     */
    public static Node preInsert(Node head, List<Object> nums){
        for(Object value : nums){
            if(head == null){
                head = new Node((Integer) value);
            }else{
                Node node = new Node((Integer) value);
                node.next = head;
                head = node;
            }
        }
        return head;
    }

    /**
     * 后序插入数组
     * 数组 1 2 3 4 5 6
     * 链表 1 2 3 4 5 6
     * @param head
     * @param nums
     * @return
     */
    public static Node postInsert(Node head,  List<Object> nums){
        Node node, nodeP = null;
        for(Object value : nums){
            if(head == null){
                head = new Node((Integer) value);
                nodeP = head;
            }else{
                node = new Node((Integer) value);
                if(nodeP == null){
                   return head;
                }
                nodeP.next = node;
                nodeP = node;
            }
        }
        return head;
    }

    public static void printList(Node head){
        if(head == null) {
            return;
        }
        printListCore(head);
    }

    /**
     * 栈结构存储链表，时间复杂度o(n)+o(n)，1次压栈1次出栈。
     * @param head
     */
    public static void printListCore(Node head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.key);
            head = head.next;
        }
        boolean flag = true;
        while(!stack.empty()){
            if(flag){
                System.out.print(stack.peek());
                flag = false;
            }else{
                System.out.print(" " + stack.peek());
            }
            stack.pop();
        }
    }
}
