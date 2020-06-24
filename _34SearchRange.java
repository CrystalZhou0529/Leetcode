package com.test.leetcode;

class _34SearchRange {

	public static int[] searchRange(int[] nums, int target) {
        
		int left = 0, right = nums.length-1, mid;
		int[] ans = new int[2];
		boolean flag = false;
		
		while (left<=right && !flag) {
			mid = (left+right+1) / 2;
			//System.out.println(mid);
			if ((mid==nums.length-1 || nums[mid+1]>nums[mid]) && nums[mid]==target) {
				System.out.println(mid);
				ans[1]=mid;
				flag = true;
				//return null;
			}
			else if (nums[mid]<target) left = mid+1;
			else if (nums[mid]>target) right = mid-1;
			else if (nums[mid]==target) left = mid;
		}
		if (!flag) ans[1]=-1;
		
		left = 0; right = nums.length-1;
		flag = false;
		while (left<=right && !flag) {
			mid = (left+right) / 2;
			//System.out.println(left+" "+right);
			if ((mid==0 || nums[mid-1]<nums[mid]) && nums[mid]==target) {
				System.out.println(mid);
				ans[0]=mid;
				flag = true;
				//return null;
			}
			else if (nums[mid]<target) left = mid+1;
			else if (nums[mid]>target) right = mid-1;
			else if (nums[mid]==target) right = mid;
		}
		if (!flag) ans[0]=-1;
		
		return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,8};
		int target = 9;
		System.out.println(searchRange(nums, target));
	}

}
