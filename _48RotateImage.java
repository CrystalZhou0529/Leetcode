package com.test.leetcode;

class _48RotateImage {

	static void printt(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
        for (int i=0; i<(n+1)/2; i++) {
        	for (int j=0; j<n/2; j++) {
        		int t = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][i];
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		matrix[j][n-1-i] = t;
        		//printt(matrix);
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,2,3,0},
				{4,5,6,1},
				{7,8,9,3},
				{13,14,15,16}
				};
		rotate(matrix);
		printt(matrix);
	}

}
