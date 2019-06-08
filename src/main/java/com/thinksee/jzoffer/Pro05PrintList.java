package com.thinksee.jzoffer;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author thinksee
 * @since 2019-5-28
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class Pro05PrintList {
    static class Node{
        int key;
        Node next;
        Node(int key){
            this.key = key;
        }
    }

    static Node insertPre(Node head, List<Integer> nums){
        for(int value : nums){
            if(head == null){
                head = new Node(value);
            }else{
                Node node = new Node(value);
                node.next = head;
                head = node;
            }
        }
        return head;
    }

    static Node insertPost(Node head,  List<Integer> nums){
        Node node, nodeP = null;
        for(int value : nums){
            if(head == null){
                head = new Node(value);
                nodeP = head;
            }else{
                node = new Node(value);
                if(nodeP == null){
                   return head;
                }
                nodeP.next = node;
                nodeP = node;
            }
        }
        return head;
    }

    static void printList(Node head){
        if(head == null) {
            return;
        }
        printListCore(head);
    }

    static void printListCore(Node head) {
        Stack<Integer> stack = new Stack<>();
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
    public static void main(String[] args) {
        int[] nums = {3,2,5,11,17,31,18,22,45,23};
        Node head = null;
        head = insertPre(head, Arrays.stream(nums).boxed().collect(Collectors.toList()));
        printList(head);
        System.out.println();
        head = null;
        head = insertPost(head, Arrays.stream(nums).boxed().collect(Collectors.toList()));
        printList(head);
    }
}
