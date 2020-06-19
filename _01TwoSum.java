
package com.test.leetcode;
import java.util.HashMap;


class _01TwoSum {

	public static int[] Solution(int[] num, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] ans = new int[2];
		
		for (int i=0; i<num.length; i++) {
			if (map.containsKey(target - num[i])) {
				ans[0]=map.get(target-num[i]);
				ans[1]=i;
				return ans;
			} else {
				map.put(num[i], i);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int[] number = new int[] {2,3,4,5};
		int target = 6;
		int[] ans = Solution(number, target);
		System.out.print(ans[0]+" "+ans[1]);
	}

}

