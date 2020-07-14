package com.test.leetcode;
import java.util.*;
class _98ValidateBST {
	
	public boolean isValidBST(TreeNode root) {
        int pre = -2147483647;
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()) {
            if (root!=null) {
                s.add(root);
                root = root.left;
            } else {
                int data = s.peek().val;
                if (pre!=-2147483647 && pre>=data) return false;
                pre = data;
                root = s.peek().right;
                s.pop();
            }
        }
        return true;
    }
	
}
