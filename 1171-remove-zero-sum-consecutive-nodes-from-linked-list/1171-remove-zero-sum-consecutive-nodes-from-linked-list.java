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
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(prefixSum, dummy);
        while(head!=null) {
            prefixSum += head.val;
            if(map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum);
                int sum = prefixSum;
                while(start!=null && start!=head) {
                    start = start.next;
                    sum += start.val;
                    if(start!=head)
                        map.remove(sum);
                }
                map.get(prefixSum).next = head.next;
            }
            else {
                map.put(prefixSum, head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}