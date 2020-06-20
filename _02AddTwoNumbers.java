package com.test.leetcode;


class _02AddTwoNumbers {

	void nnextDight(ListNode i) {
		while(i.val==9) {
			i.val=0;
			if(i.next!=null) {
				i=i.next;
			} else {
				i.next=new ListNode();
				i=i.next;
			}
		}
		i.val+=1;
	}
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	
		
		ListNode i=l1;
		ListNode j=l2;
		int nextDigit=0;
		
		while(i.next!=null && j.next!=null) {
			i.val=i.val+j.val+nextDigit;
			nextDigit=(int)i.val/10;
			i.val%=10;
			i=i.next; j=j.next;
		}
		
		if(i.next==null && j.next!=null) {
			i.val=i.val+j.val+nextDigit;
			nextDigit=(int)i.val/10;
			i.val%=10;
			i.next=j.next;
			if(nextDigit==1) {
				nnextDight(i.next);
			}
			
		} else if (i.next!=null && j.next==null) {
			i.val=i.val+j.val+nextDigit;
			nextDigit=(int)i.val/10;
			i.val%=10;
			if(nextDigit==1) {
				nnextDight(i.next);
			}
		} else {
			i.val=i.val+j.val+nextDigit;
			nextDigit=(int)i.val/10;
			i.val%=10;
			if (nextDigit!=0) {
				ListNode ln = new ListNode();
				ln.val=1;
				i.next=ln;
			}
		}
		return l1;
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
