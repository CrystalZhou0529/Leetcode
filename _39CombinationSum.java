package com.test.leetcode;
import java.util.*;

class _39CombinationSum {
	//static List<List<Integer>> res = new LinkedList<>();
	//static List<Integer> ans = new LinkedList<>();
	//static int x = 0;
	
	public static void dfs (List<List<Integer>> res, List<Integer> ans, int sum, int i, int target, int[] candidates) {
		//System.out.println("Init:"+ans+" sum="+sum+" i="+i);
		int origin = sum;
		if (i<candidates.length-1) dfs(res, ans, sum, i+1, target, candidates);
		for (int j = 1; j<=(target-origin)/candidates[i]; j++) {
			sum = origin + j*candidates[i];
			ans.add(candidates[i]);
			//System.out.println(ans);
			if (sum==target) {
				res.add(new LinkedList<>(ans));
				//System.out.println(ans);
			} else if (sum<target && i<candidates.length-1) dfs(res, ans, sum, i+1, target, candidates);
		}
		sum = origin;
		while (ans.size()>0 && ans.contains(candidates[i])) ans.remove(ans.size()-1);
		
		//System.out.println("Final:"+ans+" sum="+sum+" i="+i);
		/*if (i<candidates.length-1) {
			System.out.println("hello");
			dfs(ans, sum, i+1, target, candidates);
		}*/
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>>res = new LinkedList<>();
		Arrays.sort(candidates);
		dfs(res, new LinkedList<>(), 0, 0, target, candidates);
		
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,5};
		int target = 8;
		System.out.println(combinationSum(candidates, target));
	}

}
