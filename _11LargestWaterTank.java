package com.test.leetcode;

class _11LargestWaterTank {

	//Brute force
	//time complexity: O(n^2)
	public static int maxArea(int[] height) {
        int ans=0;
        for (int i=0; i<height.length-1; i++) {
            for (int j=i+1; j<height.length; j++) {
                ans=Math.max(ans, (j-i)*Math.min(height[i], height[j]));
            }
        }
        return ans;
    }
	
	public static int maxArea2(int[] height) {
		int ans=0;
		int left=0, right=height.length-1;
		while (left<right) {
			ans=Math.max(ans, (right-left)*Math.min(height[left], height[right]));
			if (height[left]<height[right]) {
				left+=1;
			} else {
				right-=1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = {1,8,5,3,2,6,1};
		System.out.println(maxArea(h));
		System.out.println(maxArea2(h));
		

	}

}
