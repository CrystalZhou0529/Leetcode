package com.test.leetcode;

class _55JumpGame {

	public static boolean canJump(int[] nums) {
        int farthest = 0;
        if (nums.length==1) {
           return true;
        }
        for (int i=0; i<nums.length-1; i++){
            if (farthest<i) return false;
            farthest = Math.max(farthest, i+nums[i]);
            if (farthest>=nums.length-1) return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
