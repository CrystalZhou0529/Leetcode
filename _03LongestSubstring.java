package com.test.leetcode;

import java.util.HashMap;

class _03LongestSubstring {
	static int lengthOfLongestSubstring(String s) {
		int len=0;
		int ans=0;
		int latest=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			if((map.containsKey(s.charAt(i))) && (map.get(s.charAt(i))>=latest)) {
				int res=map.get(s.charAt(i));
				latest=1+res;
				map.put(s.charAt(i), i);
				len=i-res;
			} else {
				len+=1;
				if(len>(i-latest+1)) {
					len=i-latest+1;
				}
				map.put(s.charAt(i), i);
				
			}
			if(len>ans) {
				ans=len;
			}
			//System.out.println(len+" "+latest);
		}
		return ans;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=lengthOfLongestSubstring("abcabcbb");
		
	}
}
