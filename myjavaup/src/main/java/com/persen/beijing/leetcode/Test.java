package com.persen.beijing.leetcode;

/**
 * Created by lijianyu on 2020/3/27.
 */
public class Test {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        if(grid == null)
            return 0;
        int row = grid.length;
        if(row == 0) return 0;
        int column = grid[0].length;

        int num = 0;
        for(int i=0;i<row; i++) {
            for(int j=0; j<column; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    find(grid, i, j);
                }
            }
        }
        return num;
    }

    public static void find(char[][] grid, int l, int r) {
        int row = grid.length;
        int column = grid[0].length;
        grid[l][r] = '0';
        if(l > 0 && grid[l-1][r] == '1') find(grid, l-1, r);
        if(l+1 < row && grid[l+1][r] == '1') find(grid, l+1, r);
        if(r > 0 && grid[l][r-1] == '1') find(grid, l, r-1);
        if(r+1 < column && grid[l][r+1] == '1') find(grid, l, r+1);
    }
}
