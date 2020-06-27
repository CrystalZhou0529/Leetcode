package com.test.leetcode;
import java.util.*;

class _49GroupAnagram {

	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0) return new LinkedList<>();
        int[] count = new int[27];
        Map<String, List> ans = new HashMap<String, List>();
        for (String s:strs) {
        	Arrays.fill(count, 0);
        	for (char c:s.toCharArray()) {
        		count[c-'a']++;
        	}
        	String key = new String("");
        	for (int i=0; i<26; i++) {
        		key+="#";
        		key+=count[i];
        	}
        	if (ans.containsKey(key)) {
        		ans.get(key).add(s);
        	} else {
        		ans.put(key, new LinkedList<>());
        		ans.get(key).add(s);
        	}
        }
        return new LinkedList<>(ans.values());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}

}
