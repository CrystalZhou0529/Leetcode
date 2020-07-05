package com.test.leetcode;

class _75SortColors {

	private static void sortColors(int[] nums) {
        int num0 = 0;
        int num2 = nums.length-1, i = 0;
        int len = nums.length;
        while (i<=num2) {
        	if (nums[i]==0) {
                int t = nums[i]; nums[i] = nums[num0]; nums[num0] = t;
                num0++; i++;
            } else if (nums[i]==2) {
            	int t = nums[i]; nums[i] = nums[num2]; nums[num2] = t;
                num2--;
            } else {
            	i++;
            }
        	//for (int j=0; j<nums.length; j++) System.out.print(nums[j]+" ");
        	//System.out.println();
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,0,1};
		sortColors(nums);
		for (int i=0; i<nums.length; i++) System.out.print(nums[i]+" ");
	}

}
