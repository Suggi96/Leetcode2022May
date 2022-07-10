class Solution {
    public int fillCups(int[] amount) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i: amount) {
            if(i!=0)
                pq.add(i);
        }
            
        
        while(pq.size()!=0) {
            if(pq.size()>=2) {
                int max1 = pq.poll();
                int max2 = pq.poll();
                max1--;
                max2--;
                if(max1!=0)
                    pq.offer(max1);
                if(max2!=0)
                    pq.offer(max2);
                time++;
            }
            else {
                time += pq.poll();
            }
        }
        return time;
    }
}