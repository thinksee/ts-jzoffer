package com.thinksee.jzoffer;

import org.junit.Assert;
import org.junit.Test;

public class J06ConstructBinaryTreeTest {
    @Test
    public void testExample() throws Exception{
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postorder = {7, 4, 2, 5, 8, 6, 3, 1};
        Assert.assertArrayEquals(postorder, J06ConstructBinaryTree.postTraversal(J06ConstructBinaryTree.construct(preorder, inorder)));
    }
}
