package com.test.leetcode;

class _70ClimbStairs {

	
	public int climbStairs(int n) {
        int a = 1, b = 1, c = 1;
        for (int i=1; i<n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
	
}
