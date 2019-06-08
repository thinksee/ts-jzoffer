package com.thinksee.jzoffer;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 */
public class J39BinaryTreeDepth {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static int getBinaryTreeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        return getBinaryTreeDepthCore(root);
    }

    public static int getBinaryTreeDepthCore(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = getBinaryTreeDepthCore(root.left);
        int right = getBinaryTreeDepthCore(root.right);
        return left > right ? left + 1 :right + 1;
    }
}
