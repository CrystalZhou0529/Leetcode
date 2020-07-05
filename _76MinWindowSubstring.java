package com.test.leetcode;

import java.util.*;

class _76MinWindowSubstring {

	private static String minWindow(String s, String t) {
        
		if (s.length()==0 || t.length()==0) return "";
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		int tsize = 0;
		for (char i : t.toCharArray()) {
			if (dict.containsKey(i)) {
				dict.put(i, dict.get(i)+1);
			} else {
				dict.put(i, 1); tsize++;
			}
		}
		//System.out.println(tsize);
		
		Map<Character, Integer> sdict = new HashMap<Character, Integer>();
		int left = 0, right = 0, ssize = 0;
		int l = 0, r = 0, min=-1;
	
		while (right<s.length()) {
			char c = s.charAt(right);
			if (sdict.containsKey(c)) sdict.put(c, sdict.get(c)+1);
			else sdict.put(c, 1);
			if (dict.containsKey(c) && sdict.get(c).intValue()==dict.get(c).intValue()) ssize++;
			while (left<=right && ssize==tsize) {
				//System.out.println(left+", "+right+", "+sdict.get('a'));
				if (right-left+1<min || min==-1) {
					l = left; r = right; min = right - left + 1;
				}
				char d = s.charAt(left);
				sdict.put(d, sdict.get(d)-1);
				//System.out.println(left+", "+right+", "+sdict.get('a'));
				if (dict.containsKey(d) && sdict.get(d).intValue()<dict.get(d).intValue()) {
					ssize--;
				}
				left++;
			}
			right++;
		}
		if (min==-1) return "";
		else return s.substring(l, r+1);
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaacbab";
		String t = "abc";
		System.out.println(minWindow(s, t));
		//System.out.println("end");
	}

}
