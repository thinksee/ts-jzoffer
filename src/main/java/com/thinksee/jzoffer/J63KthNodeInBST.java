package com.thinksee.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author thinksee
 * @since 2019-5-28
 * 给定一棵二叉搜索树，请找出其中的第k小结点。
 */
public class J63KthNodeInBST {

    static class BSTNode{
        BSTNode left;
        BSTNode right;
        Integer value;
        BSTNode(Integer value){
            this.value = value;
        }
    }

    static BSTNode kthNode(BSTNode root, Integer kth){
        if(root == null || kth == null || kth == 0){
            return null;
        }
        return kthNodeCore(root, kth);
    }

    /**
     * 二叉搜索树的中序遍历是有序
     * @param root
     * @param kth
     * @return
     */
    static BSTNode kthNodeCore(BSTNode root, Integer kth){
        BSTNode target = null;
        if(root.left != null){
            target = kthNodeCore(root.left, kth);
        }
        if(target == null){
            if(kth == 1){
                target = root;
            }
            --kth;
        }
        if(target == null && root.right != null){
            target = kthNodeCore(root.right, kth);
        }
        return target;
    }

    static BSTNode kthNodeCore1(BSTNode root, Integer kth){
        if(root != null){
            kthNodeCore1(root.left, kth);
            if(1 == kth){
                return root;
            }
            --kth;
            kthNodeCore1(root.right, kth);
        }
        return null;
    }

    static BSTNode kthNodeCore2(BSTNode root, Integer kth){
        Stack<BSTNode> stack = new Stack<BSTNode>();
        while(null != root || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.peek();
                stack.pop();
                if(--kth == 0){
                    return root;
                }
                root = root.right;
            }
        }
        return null;
    }

    static BSTNode insert(BSTNode root, Integer key){
        System.out.println("insert");
        if(root == null){
            root =  new BSTNode(key);
            return root;
        }else{
            if(root.value < key){
                return insert(root.left, key);
            }else{
                return insert(root.right, key);
            }
        }
    }

    static List<Integer> traverse(BSTNode root){
        List<Integer> res = new ArrayList<Integer>();
        Stack<BSTNode> stack = new Stack<BSTNode>();
        while (root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.peek();
                stack.pop();
                System.out.println("traverse()");
                res.add(root.value);
                root = root.right;
            }
        }
        return res;
    }

}
