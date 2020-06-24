package com.test.leetcode;

class _41FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
        Boolean[] check = new Boolean[nums.length+2];
        for (int i=1; i<=nums.length+1; i++) {
           check[i]=false;
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0 && nums[i]<=nums.length) check[nums[i]]=true;
        }
        int min = 1;
        while (check[min]==true) {
        	min++;
        }
        return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,0,1};
		System.out.println(firstMissingPositive(nums));
	}

}
