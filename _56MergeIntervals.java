package com.test.leetcode;
import java.util.*;

class _56MergeIntervals {

	
	public static int[][] merge(int[][] intervals) {
		if (intervals.length<=1) return intervals;
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		int start = intervals[0][0], end = intervals[0][1];
		List<int[]> ans = new LinkedList<>();
		for (int i=1; i<intervals.length; i++) {
			if (intervals[i][0]<=end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				ans.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		ans.add(new int[] {start, end});
		return ans.toArray(new int[ans.size()][2]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(merge(intervals));
	}

}
