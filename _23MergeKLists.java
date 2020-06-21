package com.test.leetcode;
import java.util.*;

class _23MergeKLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode last = ans;
        if (l1==null) return l2;
        else if (l2==null) return l1;
        do {
            if (l1.val<=l2.val) {
                last.next=l1;
                last=l1;
                l1=l1.next;
            } else {
                last.next=l2;
                last=l2;
                l2=l2.next;
            }
            
        } while (l1!=null && l2!=null);
        if (l1==null) last.next=l2;
        if (l2==null) last.next=l1;
        return ans.next;
    }
	
	public static ListNode merge(ListNode[] lists, int left, int right) {
		if (left==right) return lists[left];
		int mid = (left+right) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid+1, right);
		return mergeTwoLists(l1, l2);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length==0) return null;
		return merge(lists, 0, lists.length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
