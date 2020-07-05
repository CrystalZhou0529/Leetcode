package com.test.leetcode;

import java.util.*;

class _78Subset {

	
	public static void backtrack(List<List<Integer>> res, List<Integer> ans, int start, int[] nums) {
		
		res.add(new LinkedList<>(ans));
		for (int i=start; i<nums.length; i++) {
			ans.add(nums[i]);
			backtrack(res, ans, i+1, nums);
			ans.remove(ans.size()-1);
		}
	}
	
	public static void backtrack_adv(List<List<Integer>> res, List<Integer> ans, int start, int[] nums){
		if (start==nums.length) {
			res.add(new LinkedList<>(ans));
		} else {
			ans.add(nums[start]);
			backtrack_adv(res, ans, start+1, nums);
			ans.remove(ans.size()-1);
			backtrack_adv(res, ans, start+1, nums);
		}
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> ans = new LinkedList<>();
		/*Boolean[] f = new Boolean[nums.length];
		Arrays.fill(f, false);*/
		backtrack_adv(res, ans, 0, nums);
		return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3,4,6,8};
		System.out.println(subsets(nums));
	}

}
