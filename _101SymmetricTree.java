package com.test.leetcode;

public class _101SymmetricTree {
	
	    public static boolean backtrack(TreeNode t1, TreeNode t2) {
	        if (t1==null && t2==null) return true;
	        else if (t1==null || t2==null) return false;
	        else {
	            return (t1.val==t2.val && backtrack(t1.left,t2.right) && backtrack(t1.right,t2.left));
	        }
	    }
	    
	    public boolean isSymmetric(TreeNode root) {
	        return backtrack(root, root);
	    }
	
}
