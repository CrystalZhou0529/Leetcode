package com.test.leetcode;

class _84LargestRectangle {

	public static int largestRectangleArea(int[] heights) {
        int[][] stack = new int[heights.length][2];
        int top = 0, max = 0;
        for (int i=0; i<heights.length; i++) {
        	if (top==0 || heights[i]>stack[top-1][0]) {   //second one taller than first one.
        		stack[top][0] = heights[i]; stack[top][1] = i;
        		top++;
        		max = Math.max(max, heights[i]);
        	} else {
        		int j = top-1;
        		while (top>0 && stack[top-1][0]>=heights[i]) {
        			j=stack[top-1][1];
        			max = Math.max(max, stack[top-1][0]*(i-j));
        			top--;
        		}
        		stack[top][0] = heights[i]; stack[top][1] = j; top++;
        		max = Math.max(max, heights[i]*(i-j+1));
        		//System.out.println(j);
        	}
        	//for (int x = 0; x < top; x++) System.out.println(stack[x][0]+" "+stack[x][1]);
        	//System.out.println("i="+i+"  max="+max+"  top="+top);
        }
        if (top>0) {
        	int len = heights.length-1;
        	while (top>0) {
        		max = Math.max(max, stack[top-1][0]*(len-stack[top-1][1]+1));
        		//System.out.println(stack[top-1][0]+" "+(len-stack[top-1][1]+1));
        		top--;
        		
        	}
        }
        
		return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {2,1,5,4,2,3,1,2,3,2};
		System.out.println(largestRectangleArea(heights));
	}

}
