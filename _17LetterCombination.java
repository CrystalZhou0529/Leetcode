package com.test.leetcode;
import java.util.*;

class _17LetterCombination {
	public static char[][] dataset = {{'a','b','c'},{'d','e','f'}, {'g','h','i'},{'j','k','l'},
			{'m','n','o'},{'p','q','r','s'}, {'t','u','v'},{'w','x','y','z'}};
	public static List<String> ans = new LinkedList<>();
	
	public static void dfs(String digits, String ansstr) {
		if (digits.length()==0) {
			ans.add(ansstr);
			
		} else {
			int num = (int) digits.charAt(0);
			num-=50;
			//System.out.println(dataset[num].length);
			for (int i = 0; i < dataset[num].length; i++) {
				dfs(digits.substring(1), ansstr+dataset[num][i]);
			}
		}
		
	}
	
	public static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3";
		dfs(s,"");
		System.out.println(ans);
	}

}
