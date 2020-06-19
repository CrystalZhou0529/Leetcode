package com.test.leetcode;

class _10RegExpression {
	
	public static boolean matchChar(char a, char b) {
		if (a==b || b=='.') {
			return true;
		}
		return false;
	}
	
	public static boolean isMatch(String s, String p) {
		
		//System.out.println(s+"   "+p);
		if (p.length()==0) {
			return(s.length()==0);
		}
		if (p.length()>1 && p.charAt(1)=='*') {
			if (isMatch(s, p.substring(2))) {
				return true;
			} else {
				if (s.length()>0 && matchChar(s.charAt(0), p.charAt(0))) {
					return isMatch(s.substring(1), p);
				}
			}
			return false;
		}
		if (s.length()>0 && matchChar(s.charAt(0), p.charAt(0))) {
			return isMatch(s.substring(1), p.substring(1));
		}
		return false;
		
		
	}
	
	public static void main(String[] args) {
		String a = "aa";
		String b = "a";
		
		System.out.println(isMatch(a,b));
	}
	
}
