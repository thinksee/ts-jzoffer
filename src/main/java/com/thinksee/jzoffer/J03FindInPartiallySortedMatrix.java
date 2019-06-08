package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 在一个二维数组中，每行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 输入这样一个数组和一个整数，判断数组中是否含有该整数。
 */
class J03FindInPartiallySortedMatrix {
    /**
     * 从右上角(从列上看，此角是最小值，从行上看，此角是最大值)或者
     * 或者左下角(从列上看，此角是最大值，从行上看，此角是最小值)遍历。
     *
     * @param matrix 传入的矩阵
     * @param key 要查询的值
     * @return
     */
    static boolean hasKeyInPartiallySortedMatrix(int[][] matrix, int key){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int row = 0, col = matrix[0].length - 1, rows = matrix.length;
        while(row < rows && col >= 0){
            int tmp = matrix[row][col];
            if(tmp == key){
                return true;
            }else if(tmp < key){
                ++row;
            }else{
                --col;
            }
        }
        return false;
    }
}
