package com.test.leetcode;
/*class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

class _21MergeTwoLists {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
