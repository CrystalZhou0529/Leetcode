package com.test.leetcode;

class _53MaxSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i=1; i<nums.length; i++) {
            sum = Math.max(nums[i], sum+nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
