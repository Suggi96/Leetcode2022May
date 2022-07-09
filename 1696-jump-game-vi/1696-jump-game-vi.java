class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if(n==1) 
            return nums[0];
        //score, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]- a[0])); //create max heap based on score value b[0] - a[0]
        pq.add(new int[] {nums[0], 0}); //add first element of nums array
        int maxScore = nums[0];
        for(int i=1;i<n;i++) {
            while(i-pq.peek()[1] > k ) {
                pq.poll();
            }
            int[] cur = pq.peek();
            maxScore = cur[0] + nums[i];
            pq.offer(new int[] {maxScore, i});
        }
        return maxScore;
        
    }
}