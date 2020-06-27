package com.test.leetcode;
import java.util.*;

class _46Permutations {

	static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums) {
		//System.out.println(temp);
		if (temp.size()==nums.length) {
			ans.add(new LinkedList<>(temp));
		} else {
			for (int i=0; i<nums.length; i++) {
				if (!temp.contains(nums[i])) {
					temp.add(nums[i]);
					backtrack(ans, temp, nums);
					temp.remove(temp.size()-1);
				}
			}
		}
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(ans, new LinkedList<>(), nums);
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,5,6,7};
		System.out.println(permute(nums));
	}

}
