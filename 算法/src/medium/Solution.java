package medium;

/**
 * TODO:Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * 代码提交结果：
 * 1563 / 1563 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 45.4 MB
 */

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3= null;
        int j=0;
        int t =0;

        ListNode l11 = l1, l22=l2;
        int m=0,n=0;

        while (l11.next!=null) {
            m++;
            l11 = l11.next;
        }

        while (l22.next!=null) {
            n++;
            l22 = l22.next;
        }

        if (m<n) {
            for(int p=0; p<(n-m); p++) {
                l11.next = new ListNode(0);
                l11= l11.next;
            }
        } else if (m>n) {
            for(int p=0; p<(m-n); p++) {
                l22.next = new ListNode(0);
                l22= l22.next;
            }
        }

        while(l1!=null) {

            if (l2 ==null) {
                j=0;
            } else {
                j = l2.val;
                l2 = l2.next;
            }

            ListNode ll = l1.next!=null?new ListNode(0):null;

            if (l3 ==null) {
                l3 = new ListNode(0);
                l3.val= (l1.val + j + t) % 10;
                l3.next = ll;
            } else {
                ListNode l4 = l3;
                while(l4.next!=null) {
                    l4 = l4.next;
                }
                l4.val= (l1.val + j + t) % 10;
                l4.next = ll;
            }

            t = (l1.val + j + t) /10 ;

            l1= l1.next;

        }



        if (t>0) {
            ListNode l4 = l3;
            while(l4.next!=null) {
                l4 = l4.next;
            }
            ListNode lPlus = new ListNode(0);
            lPlus.val= 1;
            lPlus.next = null;
            l4.next = lPlus;
        }
        return l3;
    }
}
