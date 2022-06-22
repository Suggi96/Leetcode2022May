class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i: nums) {
            if(pq.size()<k) {
                pq.offer(i);
            }
            else if(pq.size()==k && pq.peek()<i) {
                pq.poll();
                pq.offer(i);
            }
        }
        return pq.peek();
    }
}