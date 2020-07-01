package com.test.leetcode;
import java.util.*;

class _72EditDistance {

	public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+2][word2.length()+2];
        //Arrays.fill(dp, 0);
        if (word1.length()==0) return word2.length();
        if (word2.length()==0) return word1.length();
        
        for (int j = 1; j <= word2.length(); j++) {
            for (int i = 1; i <= word1.length(); i++) {
                
                if (j==1) {
                	if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = i-1;
                	else dp[i][j] = dp[i-1][j]+1;
                }
                else if (i==1) {
                	if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = j-1;
                	else dp[i][j] = dp[i][j-1]+1;
                }
                /*else if (i==j) {
                	if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                	else dp[i][j] = dp[i-1][j-1]+1;
                }*/ else {
                	if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                	else dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }
                System.out.println(i+" "+j+" "+dp[i][j]);
            }
        }
        return dp[word1.length()][word2.length()];
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "a";
		String s2 = "ab";
		System.out.println(minDistance(s1, s2));
	}

}
