class Solution {
    public int fillCups(int[] amount) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i: amount) {
                pq.add(i);
        }
            
        
        while(pq.peek()!=0) {
            int high1 = pq.poll() - 1;
            int high2 = pq.poll() - 1;
            pq.offer(high1>0?high1:0);
            pq.offer(high2>0?high2:0);
            time++;

        }
        return time;
    }
}