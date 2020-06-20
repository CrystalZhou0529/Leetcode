package com.test.leetcode;

class _20ValidParentheses {

	public static boolean isValid(String s) {
        int[] stack = new int[s.length()+1];
        int top = 0;
        for (int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch=='{' || ch=='(' || ch=='[') {
        		stack[top]=ch;
        		top++;
        	}
        	if (ch=='}') {
        		if (top>0 && stack[top-1]=='{') {
        			top--;
        		} else return false;
        	}
        	if (ch==']') {
        		if (top>0 && stack[top-1]=='[') {
        			top--;
        		} else return false;
        	}
        	if (ch==')') {
        		if (top>0 && stack[top-1]=='(') {
        			top--;
        		} else return false;
        	}
        }
        if (top!=0) return false;
        else return true;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="{[()]}";
		System.out.println(isValid(s));
	}

}
