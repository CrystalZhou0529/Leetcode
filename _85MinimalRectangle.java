package com.test.leetcode;

import java.util.Arrays;

class _85MinimalRectangle {

	public static int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n], right = new int[n];
        int max = 0;
        Arrays.fill(left, 0); Arrays.fill(right, n); Arrays.fill(height, 0);
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j]=='1') height[j]++;
        		else height[j]=0;
        		//System.out.print(height[j]+" ");
        	}
        	//System.out.println();
        	
        	int lbound = 0;
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j]=='1') {
        			left[j] = Math.max(left[j], lbound);
        		} else {
        			left[j]=0; lbound=j+1;
        		}
        		//System.out.print(left[j]+" ");
        	}
        	//System.out.println();
        	
        	int rbound = n-1;
        	for (int j = n-1; j >= 0; j--) {
        		if (matrix[i][j]=='1') {
        			right[j] = Math.min(right[j], rbound);
        			max = Math.max(max, height[j]*(right[j]-left[j]+1));
        		} else {
        			right[j]=n-1; rbound=j-1;
        		}
        		//System.out.print(right[j]+" ");
        	}
        	//System.out.println();
        	//System.out.println();
        	
        }
        
		return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','0','1','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(matrix));
	}

}
