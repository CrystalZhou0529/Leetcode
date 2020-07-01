package com.test.leetcode;

class _62UniquePath {

	static long factorial (int i) {
        if (i==0) return 1;
        else if (i<=2) return i;
        else return i*factorial(i-1);
    }
	
    public static int uniquePaths(int m, int n) {
        long ans = 1;
        for (int i=m+n-2; i>Math.max(m-1, n-1); i--) {
        	ans*=i; ans/=(m+n-1-i);
        }
        //System.out.println(ans);
        //long div = factorial(Math.min(m-1, n-1));
        return (int)(ans);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(13,23));
	}

}
