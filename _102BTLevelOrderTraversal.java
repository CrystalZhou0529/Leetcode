package com.test.leetcode;
import java.util.*;

class _102BTLevelOrderTraversal {

	public static void dfs(List<List<Integer>> list, TreeNode root, int level) {
        if (root==null) return;
        if (list.size()<level) list.add(new LinkedList<>());
        list.get(level).add(root.val);
        dfs(list, root.left, level+1);
        dfs(list, root.right, level+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        dfs(list, root, 0);
        return list;
    }
	
}
