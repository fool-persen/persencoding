package com.persen.beijing.leetcode;

/**
 * Created by lijianyu on 2019/2/26.
 */
/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class leetcode64 {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 5;

        grid[1][0] = 3;
        grid[1][1] = 2;
        grid[1][2] = 1;
//            1 2 5
//            3 2 1
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;
        int ret = minPathSum3(grid);
        System.out.println("");
    }

    /*DP 动态规划*/
    public static int minPathSum3(int[][] grid) {
        int lineNum = grid.length;
        if (lineNum == 0) {
            return 0;
        }
        int columnNum = grid[0].length;
        if (columnNum == 0) {
            return 0;
        }

        //处理边界
        for (int i = lineNum - 2; i >= 0; i--) {
            grid[i][columnNum - 1] = grid[i][columnNum - 1] + grid[i + 1][columnNum - 1];
        }
        for (int j = columnNum - 2; j >= 0; j--) {
            grid[lineNum - 1][j] = grid[lineNum - 1][j] + grid[lineNum - 1][j + 1];
        }

        for (int i = lineNum - 2; i >= 0; i--) {
            for (int j = columnNum - 2; j >= 0; j--) {
                int right = grid[i][j + 1];
                int down = grid[i + 1][j];
                if (right >= down) {
                    grid[i][j] = grid[i][j] + down;
                } else {
                    grid[i][j] = grid[i][j] + right;
                }
            }
        }
        return grid[0][0];
    }

    /*记忆话搜索递归*/
    public static int minPathSum2(int[][] grid) {
        int lineNum = grid.length;
        if (lineNum == 0) {
            return 0;
        }
        int columnNum = grid[0].length;
        if (columnNum == 0) {
            return 0;
        }

        int[][] mem = new int[lineNum][columnNum];
        mem[lineNum - 1][columnNum - 1] = grid[lineNum - 1][columnNum - 1];
        for (int i = lineNum - 2; i >= 0; i--) {
            mem[i][columnNum - 1] = grid[i][columnNum - 1] + mem[i + 1][columnNum - 1];
        }
        for (int j = columnNum - 2; j >= 0; j--) {
            mem[lineNum - 1][j] = grid[lineNum - 1][j] + mem[lineNum - 1][j + 1];
        }

        return minPathSum2(grid, mem, 0, lineNum - 1, 0, columnNum - 1);
    }

    public static int minPathSum2(int[][] grid, int[][] mem, int lineStart, int lineEnd, int columnStart,
                                  int columnEnd) {
        if (lineStart == lineEnd || columnStart == columnEnd) {
            return mem[lineStart][columnStart];
        }

        int right = mem[lineStart][columnStart + 1];
        int down = mem[lineStart + 1][columnStart];
        if (right == 0) {
            right = minPathSum2(grid, mem, lineStart, lineEnd, columnStart + 1, columnEnd);
        }
        if (down == 0) {
            down = minPathSum2(grid, mem, lineStart + 1, lineEnd, columnStart, columnEnd);
        }
        if (right >= down) {
            mem[lineStart][columnStart] = grid[lineStart][columnStart] + down;
        } else {
            mem[lineStart][columnStart] = grid[lineStart][columnStart] + right;
        }
        return mem[lineStart][columnStart];
    }

    /*递归*/
    public static int minPathSum1(int[][] grid) {
        int lineNum = grid.length;
        if (lineNum == 0) {
            return 0;
        }
        int columnNum = grid[0].length;
        if (columnNum == 0) {
            return 0;
        }

        return minPathSum1(grid, 0, lineNum - 1, 0, columnNum - 1);
    }

    public static int minPathSum1(int[][] grid, int lineStart, int lineEnd, int columnStart, int columnEnd) {
        if (lineStart == lineEnd && columnStart == columnEnd) {
            return grid[lineStart][columnStart];
        }
        if (lineStart == lineEnd) {
            return grid[lineStart][columnStart] + minPathSum1(grid, lineStart, lineEnd, columnStart + 1, columnEnd);
        }
        if (columnStart == columnEnd) {
            return grid[lineStart][columnStart] + minPathSum1(grid, lineStart + 1, lineEnd, columnStart, columnEnd);
        }

        int right = minPathSum1(grid, lineStart + 1, lineEnd, columnStart, columnEnd);
        int down = minPathSum1(grid, lineStart, lineEnd, columnStart + 1, columnEnd);
        if (right >= down) {
            return grid[lineStart][columnStart] + down;
        } else {
            return grid[lineStart][columnStart] + right;
        }
    }

}
