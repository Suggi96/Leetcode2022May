/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null)
            return headB;
        if(headB==null)
            return headA;
        ListNode cur = headA;
        int x=0, y=0;
        while(cur!=null) {
            cur=cur.next;
            x++;
        }
        cur=headB;
        while(cur!=null){
            cur = cur.next;
            y++;
        }
        ListNode startA = headA;
        ListNode  startB = headB;
        if(x>y) {
            int diff = x - y;
            while(diff!=0) {
                startA=startA.next;
                diff--;
            }
        }
        else {
            int diff = y - x;
            while(diff!=0) {
                startB=startB.next;
                diff--;
            }
        }
        while(startA!=startB) {
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }
}