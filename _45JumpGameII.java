package com.test.leetcode;

class _45JumpGameII {

	//Solution 1: DP
	public static int jump1(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i=0; i<=nums.length; i++) dp[i]=0;
        for (int i=0; i<nums.length; i++){
            int j = 1;
            while (i+j<nums.length && j<=nums[i]) {
                if (dp[i+j]!=0) {
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                } else dp[i+j] = dp[i]+1;
                j++;
            }
        }
        return dp[nums.length-1];
    }
	
	//Solution 2: Greedy
	
	public static int jump2(int[] nums) {
		int count = 0, end = 0, farthest = 0;
		for (int i=0; i<nums.length-1; i++) {
			farthest = Math.max(farthest, i+nums[i]);
			if (i==end) {
				count++;
				end = farthest;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
