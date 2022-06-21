class Solution {
    public int furthestBuilding(int[] height, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<height.length;i++) {
            int diff = height[i] - height[i-1];
            if(diff>0) {
                if(pq.size() < ladders) {
                    pq.offer(diff);
                }
                else {
                    int br = diff;
                    //optimise ladder use
                    if(pq.size()>0 && pq.peek() < diff) {
                        br = pq.remove();
                        pq.offer(diff);
                    }
                    if(bricks - br >=0)
                        bricks -= br;
                    else
                        return i-1;
                }
            }
        }
        return height.length-1;
    }
}