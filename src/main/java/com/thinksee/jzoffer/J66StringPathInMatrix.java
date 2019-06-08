package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-27
 * 设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中
 * 任意位置开始，每一步可以左右上下移动一格。若其中一条路径经过了某一格，那么该路径不能再次进入
 * 该格子。
 */
public class J66StringPathInMatrix {
    final static int[][] directions ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean hasPath(char[][] matrix, String str){
        if(matrix == null || matrix.length < 1 && matrix[0].length < 1 || str.length() == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] visited = new boolean[rows * cols];
        int pathLen = 0;
        // 1. 条条大路通罗马。统计以每个点开始的路径
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(hasPathCore(matrix, i, j, rows, cols, visited, pathLen, str)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hasPathCore(char[][] matrix, int row, int col, int rows, int cols, boolean[] visited, int pathLen, String str){
        // 2. 一条路走到黑。依据当前点
        if(str.length() == pathLen) {
            return true;
        }
        boolean hasPath = false;
        // 3. 检查当前点
        if(row < rows && col < cols && row > -1 && col > - 1 &&
                !visited[row * cols + col] &&
                matrix[row][col] == str.charAt(pathLen)){
            ++pathLen;
            // 4. 设置被访问
            visited[row * cols + col] = true;
            int i = row;
            int j = col;
            for(int[] direction : directions){
                i += direction[0];
                j += direction[1];
                hasPath |=  hasPathCore(matrix, i, j, rows, cols, visited, pathLen, str);
                i = row;
                j = col;
            }
            // 5. 清除访问标志
            if(!hasPath){
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c','s'}, {'a', 'd', 'e', 'e'}};
        System.out.println(hasPath(matrix, "abfdecce"));
    }
}
