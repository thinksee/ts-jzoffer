package com.thinksee.jzoffer;

import org.junit.Test;

public class J66StringPathInMatrixTest {
    @Test
    public void testExample(){
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c','s'}, {'a', 'd', 'e', 'e'}};
        assert  J66StringPathInMatrix.hasPath(matrix, "abfdecce") == false;
    }
}
