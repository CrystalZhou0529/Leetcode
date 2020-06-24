package com.test.leetcode;

class _33RotatedSortedArray {
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        if (nums.length==0) return -1;
        if (target>=nums[0]) {
            while (left<=right) {
                mid = (left+right) / 2;
                if (nums[mid]==target) return mid;
                if (nums[mid]<nums[0]) right = mid-1; 
                else if (nums[mid]>target) right = mid-1;
                else if (nums[mid]<target) left = mid+1;
            }
            return -1;
        } else {
            while (left<=right) {
                mid = (left+right) / 2;
                if (nums[mid]==target) return mid;
                if (nums[mid]>=nums[0]) left = mid+1; 
                else if (nums[mid]>target) right = mid-1;
                else if (nums[mid]<target) left = mid+1;
            }
            return -1;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
