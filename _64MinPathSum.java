package com.test.leetcode;

class _64MinPathSum {

	public static int minPathSum(int[][] grid) {
		int m = grid.length, n=grid[0].length;
		if (m==0 && n==0) return grid[0][0];
        for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		//System.out.println(i+" "+j);
        		if (i+j==0) continue;
        		if (j==0) grid[i][j]+=grid[i-1][j];
        		else if (i==0) grid[i][j]+=grid[i][j-1];
        		else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        		//System.out.println(i+" "+j+" "+grid[i][j]);
        	}
        }
        return grid[m-1][n-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1,2}, {1,5,1,3}, {4,2,1,2}, {2,1,5,2}};
		System.out.println(minPathSum(grid));
	}

}
