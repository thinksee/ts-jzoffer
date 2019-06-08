package com.thinksee.jzoffer;

import org.junit.Test;

public class J03FindInPartiallySortedMatrixTest {
    @Test
    public void testExample(){
        int[][] matrix = {{2, 4, 6, 8}, {3, 5, 8, 10}, {5, 7, 13, 19}, {7, 11, 15, 33}, {9, 13, 21, 35}};
        System.out.println(J03FindInPartiallySortedMatrix.hasKeyInPartiallySortedMatrix(matrix, 11));
    }
}
