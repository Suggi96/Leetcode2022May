class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //maxHeap
        long totalSum = 0l;
        for(int el: target) {
            pq.offer(el);
            totalSum += el;
        }
        while(!pq.isEmpty()) {
            int maxEl = pq.poll();
            long remainingTotal = totalSum - maxEl;
            
            if(maxEl==1 || remainingTotal==1)
                return true;
            
            if(remainingTotal==0 || maxEl<remainingTotal)
                return false;
            
            int updatedMax = (int)(maxEl % remainingTotal);
            if(updatedMax==0) 
                return false;
            
            maxEl = updatedMax;
            pq.offer(maxEl);
            totalSum = updatedMax + remainingTotal;
            
        }
        return true;
    }
}