package com.test.leetcode;

class _04MedianOfTwoArray {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if(nums1.length>nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		int left = 0; int right = nums1.length;
		int m=nums1.length, n=nums2.length;
		int i=0, j=0;
		while ((left <= right) && (left>=0) && (right<=nums1.length)) {
			
			i = (left+right) / 2;
			j = (m+n+1)/2-i;
			//System.out.println(i+" "+j);
			int lefmax, rigmin;
			
			if ( i>left && nums1[i-1] > nums2[j]) {
					right=i-1;
				
			} else if (i<right && nums2[j-1] > nums1[i]) {
					left=i+1;
				
			} else {
				if (i==0) { lefmax=nums2[j-1]; }
				else if (j==0) {lefmax=nums1[i-1]; }
				else { lefmax=Math.max(nums1[i-1], nums2[j-1]); }
				if ((m+n)%2==1) { return lefmax;}
				if (i==m) {rigmin=nums2[j]; }
				else if (j==n) {rigmin=nums1[i];}
				else {rigmin=Math.min(nums1[i], nums2[j]); }
				System.out.println(lefmax+" "+rigmin);
				return (lefmax+rigmin)/2;
			} 
		}
		return 0.0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {1,3};
		int[] b = new int[] {2,4};
		System.out.println(findMedianSortedArrays(a,b));
	}
}
