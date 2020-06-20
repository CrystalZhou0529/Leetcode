package com.test.leetcode;

class _19RemoveNthFromListEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for (int i=1; i<n; i++) {
            first = first.next;
        }
        if (first.next==null) {
            return head.next;
        } else first=first.next;
        ListNode second = head;
        while (first.next!=null) {
            first = first.next;
            second = second.next;
        }
        if (n==1) {
            second.next=null;
            return head;
        }
        second.next=second.next.next;
        return head;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
