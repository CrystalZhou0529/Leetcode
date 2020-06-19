package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Vector;


import java.util.Stack;
import java.util.HashMap;

class _15ThreeSum {

	public static List<Object> inputt(List<Object> ans, int a, int b, int c) {
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(a); temp.add(b); temp.add(c);
		ans.add(temp);
		return ans;
	}
	
	/*public static List<List<String>> threeSum1(int[] nums){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Object> ans = new ArrayList<Object>();
		int len = nums.length;
		for (int i=0; i<len; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int t = map.get(nums[i]);
				map.remove(nums[i]);
				map.put(nums[i], t+1);
			}
		}
		for (int i=0; i<len-2; i++) {
			for (int j=i+1; j<len-1; j++) {
				int predicted = 0-nums[i]-nums[j];
				if (nums[i]==nums[j]) {
					if (predicted!=nums[i] && map.containsKey(predicted)) {
						ans=inputt(ans, nums[i], nums[j], predicted);
					} else if (predicted==nums[i] && map.get(nums[i])>2) {
						ans=inputt(ans, nums[i], nums[j], predicted);
					}
				} else {
					if (predicted!=nums[i] && predicted!=nums[j] && map.containsKey(predicted)) {
						ans=inputt(ans, nums[i], nums[j], predicted);
					} else if (predicted==nums[i] && map.get(nums[i])>1) {
						ans=inputt(ans, nums[i], nums[j], predicted);
					} else if (predicted==nums[j] && map.get(nums[j])>1) {
						ans=inputt(ans, nums[i], nums[j], predicted);
					}
				}
			}
			
		}
		return ans;
	}*/
	
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		Arrays.sort(nums);
		/*for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}*/
		for (int i=0; i<nums.length-2; i++) {
			int left = i+1, right = nums.length-1, sum = 0-nums[i];
			if (i!=0 && nums[i]==nums[i-1]) continue;
			while (left<right) {
				if (nums[left]+nums[right]==sum && left<right) {
					ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
					while (left<right && nums[left]==nums[left+1]) {
						left++;
					}
					while (left<right && nums[right]==nums[right-1]) {
						right--;
					}
					//System.out.println(Arrays.asList(i,left,right));
					right--;
				}
				else if (nums[left]+nums[right]<sum) left++;
				else {
					right--;
				}
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[] {-1,0,1,2,-1,1,0,-2,1};
		System.out.println(threeSum2(data));
	}

}
