package com.test.leetcode;

class _79WordSearch {

	public static boolean backtrack(char[][] board, String word, int i, int j, int pos,boolean[][] f) {
        f[i][j] = true;
        if (pos==word.length()) return true;
        if (j>0 && board[i][j-1]==word.charAt(pos) && (f[i][j-1]==false) && backtrack(board,word,i,j-1,pos+1,f)) return true;
        if (i>0 && board[i-1][j]==word.charAt(pos) && (f[i-1][j]==false) && backtrack(board,word,i-1,j,pos+1,f)) return true;
        if (j<board[0].length-1 && board[i][j+1]==word.charAt(pos) && (f[i][j+1]==false) && backtrack(board,word,i,j+1,pos+1,f)) return true;
        if (i<board.length-1 && board[i+1][j]==word.charAt(pos) && (f[i+1][j]==false) && backtrack(board,word,i+1,j,pos+1,f)) return true;
        f[i][j] = false;
        return false;
        
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] f = new boolean[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++)
                if (board[i][j]==word.charAt(0)) {
                    if (backtrack(board,word,i,j,1,f)) return true;
                }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
