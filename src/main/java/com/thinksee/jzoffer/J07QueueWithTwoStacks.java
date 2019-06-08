package com.thinksee.jzoffer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。实现其两个函数appendTail和deleteHead
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 * @author thinksee
 * 思路：当压入元素的时候，只需要向stackPush压入元素；
 * 当弹出元素的时候，仅当stackPop为空的时候才把stackPush
 * 中的元素压入stackPop。
 */
public class J07QueueWithTwoStacks {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public J07QueueWithTwoStacks(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
