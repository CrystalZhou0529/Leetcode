package com.test.leetcode;

class _42TrappingRainWater {

	
	public static int trap(int[] height) {
        int[][] stackk = new int[height.length+1][2];
        int top = 0;
        int vol = 0;
        for (int i=0; i<height.length; i++) {
            //System.out.println("i="+i);
            if (top==0 || stackk[top-1][0]>height[i]) {
                stackk[top][0] = height[i];
                stackk[top][1] = i;
                top++;
            } else {
                int max = stackk[top-1][0];
                while (top>0 && stackk[top-1][0]<=height[i]) {
                	//System.out.println("max="+max+"  stack[last]="+stackk[top-1][0]);
                    if (stackk[top-1][0]>max) {
                        vol += (i-stackk[top-1][1]-1) * (stackk[top-1][0]-max);
                        max = stackk[top-1][0];
                    }
                    top--;
                }
                if (top>0 && stackk[top-1][0]>height[i]) vol += (i-1-stackk[top-1][1]) * (height[i]-max);
                stackk[top][0] = height[i];
                stackk[top][1] = i;
                top++;
            }
            for(int j=0; j<top; j++) System.out.println("stack["+j+"]="+stackk[j][0]+" i="+stackk[j][1]);
            //System.out.println("vol="+vol);
        }
        return vol;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,3,1,2,4,1,0,2};
		System.out.println(trap(height));
	}

}
