package com.test.leetcode;
import java.util.*;

class _94BinaryTreeInorderTraversal {

	
	// Solution 1: using stack
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        
        while (root!=null || !s.isEmpty()) {
        	if (root==null) {
        		ans.add(s.peek().val);
        		root = s.peek().right;
        		s.pop();
        	} else {
        		s.add(root);
        		root = root.left;
        	}
        }
        
        return ans;
    }

	
	// Solution 2: using deep first search; faster and consumes less space
	private static void dfs(List<Integer> list, TreeNode root) {
		if (root==null) return;
		dfs(list, root.left);
		list.add(root.val);
		dfs(list, root.right);
	}
	
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		dfs(list, root);
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
