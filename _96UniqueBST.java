package com.test.leetcode;

import java.io.IOException;

class _96UniqueBST {

	//Solution 1: directly using the formula for Catalan number
	public static int numTrees1(int n) {
        long ans = 1;
        for (int i = 1; i<=n-1; i++) {
            ans = ans * (n+1+i) / i;
        }
        ans/=n;
        return (int)ans;
    }
	
	//Solution 2: DP
	public static int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0]=1; dp[1]=1;
		for (int i=2; i<=n; i++) {
			dp[i]=0;
			for (int j=0; j<i; j++) dp[i]+=dp[j]*dp[i-1-j];
		}
		return dp[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;

		System.out.println("n="+n);
		System.out.println(numTrees1(n));
		System.out.println(numTrees(n));
	}

}
