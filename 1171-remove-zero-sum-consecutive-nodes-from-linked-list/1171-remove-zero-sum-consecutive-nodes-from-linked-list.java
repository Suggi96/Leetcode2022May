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
public static ListNode removeZeroSumSublists(ListNode head) {
    int prefixSum = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    Map<Integer, ListNode> hashMap = new HashMap<>();
    hashMap.put(0, dummy);
    for (ListNode i = dummy; i != null; i = i.next) {
        prefixSum += i.val;
        hashMap.put(prefixSum, i);
    }
    prefixSum = 0;
    for (ListNode i = dummy; i != null; i = i.next) {
        prefixSum += i.val;
        i.next = hashMap.get(prefixSum).next;
    }
    return dummy.next;
}
    
}