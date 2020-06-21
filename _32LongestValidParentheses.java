package com.test.leetcode;

class _32LongestValidParentheses {

	public static int longestValidParentheses(String s) {
        int ans = 0;
        int[] length = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i)=='(') {
        		length[i] = 0;
        	} else if (i>=1) {
        		if (s.charAt(i-1)=='(') {
        			if (i-2<0) length[i] = 2;
        			else length[i] = length[i-2] + 2;
        		} else if (i-length[i-1]>=1 && s.charAt(i-length[i-1]-1)=='('){
        			if (i-length[i-1]-2>=0) {        		
        				length[i] = length[i-1] + 2 + length[i-length[i-1]-2];
        			} else length[i] = length[i-1] + 2;
        		}
        	}
        	if (length[i]>ans) ans = length[i];
        	System.out.println(length[i]);
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")(()()))";
		System.out.println(longestValidParentheses(s));
	}

}
