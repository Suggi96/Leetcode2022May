/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        map.put(0, dummy);
        dummy.next = head;
        int prefixSum = 0;
        for(ListNode i=dummy;i!=null;i=i.next) {
            prefixSum += i.val;
            map.put(prefixSum, i);
        }
        prefixSum = 0;
        for(ListNode i=dummy;i!=null;i=i.next) {
            prefixSum += i.val;
            i.next = map.get(prefixSum).next;
        }
        return dummy.next;
    }
}