package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-27
 * 在m x n的格子内。一个机器人从坐标(0,0)的格子开始移动，可以上下左右移动。
 * 但是不能进入坐标位数之和大于k的格子。求解机器人所能达到的格子数。
 */
public class Pro67RobotMove {
    final static int[][] directions ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * 统计结果
     * @param k  阈值
     * @param nRows 格子行数
     * @param nCols 格子列数
     * @return
     */
    static int movingCount(int k, int nRows, int nCols){
        boolean[] visited = new boolean[nRows * nCols];
        // A. 不在原来的函数上，进行递归调用，而是新建函数
        // 1. 一条路走到黑
        return movingCountCore(k, 0, 0, nRows, nCols, visited);
    }
    static int movingCountCore(int k, int startRow, int startCol, int nRows, int nCols, boolean[] visited){
        int count = 0;
        int row = startRow;
        int col = startCol;
        // 2. 检测当前点
        if(check(k, startRow, startCol, nRows, nCols, visited)){
            // 3. 设置被访问
            visited[startRow * nCols + startCol] = true;
            // 4. 按照题意的统计值
            count ++;
            for(int[] direction : directions){
                row += direction[0];
                col += direction[1];
                count += movingCountCore(k, row, col, nRows, nCols, visited);
                row = startRow;
                col = startCol;
            }
//            // 以下语句的优势在于对于每次递归时，参数值是不发生变化的，特别是row和col
//            count = 1 + movingCountCore(k, row - 1, col, nRows, nCols, visited) +
//                    movingCountCore(k, row + 1, col, nRows, nCols, visited) +
//                    movingCountCore(k, row, col - 1, nRows, nCols, visited) +
//                    movingCountCore(k, row, col + 1, nRows, nCols, visited);
        }
        return count;
    }

    static boolean check(int k, int startRow, int startCol, int nRows, int nCols, boolean[] visited){
        // 检查的条件 a:边界越界;b:是否被访问;c:提议相关限制条件
        if(startCol < nCols && startRow < nRows && startCol > -1 && startRow > -1 &&
                !visited[startRow * nCols + startCol] &&
                getDigitSum(startRow) + getDigitSum(startCol) <= k){
            return true;
        }
        return false;
    }

    static int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(movingCount(18,40,50));
    }
}
