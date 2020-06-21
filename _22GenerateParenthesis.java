package com.test.leetcode;
import java.util.*;

class _22GenerateParenthesis {
	public static List<String> listt = new LinkedList<>();
    
    public static void dfs(String ans, int left, int len, int n) {
    	System.out.print(ans);
    	System.out.println(left);
        if (len==n*2 && left==0) {
        	listt.add(ans);
        	System.out.println(ans);
        }
        else if (len<n*2) {
            if (left<n) {
                dfs(ans+"(", left+1, len+1, n);
            }
            if (left>=1) {
                dfs(ans+")", left-1, len+1, n);
            }
        }
    }
    
    public static List<String> generateParenthesis(int n) {
        listt = new LinkedList<>();
        dfs("",0,0,n);
        return listt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}

}
