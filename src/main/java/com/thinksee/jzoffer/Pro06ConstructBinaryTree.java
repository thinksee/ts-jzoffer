package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-29
 * 输入某二叉树的前序遍历和中序遍历，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历
 */
public class Pro06ConstructBinaryTree {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    BinaryTreeNode construct(int[] preorder, int[] inorder) throws Exception{
        if(null == preorder || null == inorder){
            return null;
        }
        int preLen = preorder.length, inLen = inorder.length;
        if( preLen != inLen){
            return null;
        }
        return constructCore(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    BinaryTreeNode constructCore(int[] preorder, int startPreorder, int endPreorder, int[] inorder, int startInorder, int endInorder) throws Exception{
        int rootValue = preorder[startPreorder];
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootValue;
        if(startPreorder == endPreorder){
            if(startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]){
                return root;
            }else{
                throw new Exception("Invalid input.");
            }
        }
        int rootInorder = startInorder;
        while(rootInorder <= endInorder && inorder[rootInorder] != rootValue){
            rootInorder++;
        }

        if(rootInorder == endInorder && inorder[rootInorder] != rootValue){
            throw new Exception("Invalid input.");
        }

        int leftLength = rootInorder - startInorder;
        int leftPreorderEnd = startPreorder + leftLength;

        if(leftLength > 0){
            root.left = constructCore(preorder, startPreorder + 1, leftPreorderEnd, inorder, startInorder, rootInorder - 1);
        }
        if(leftLength < endPreorder - startPreorder){
            root.right = constructCore(preorder, leftPreorderEnd + 1, endPreorder, inorder, rootInorder + 1, endInorder);
        }
        return root;
    }
}
