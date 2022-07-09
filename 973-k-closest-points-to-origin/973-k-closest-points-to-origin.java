class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //distance, index 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); //min heap
        int idx = 0;
        for(int[] p: points) {
            int d = p[0] * p[0] + p[1] * p[1];
            pq.offer(new int[] {d, idx});
            idx++;
        }
        int[][] res = new int[k][2];
        int j = 0;
        while(pq.size()!=0 && k-- > 0) {
            int[] cur = pq.poll();
            int i = cur[1];
            res[j][0] = points[i][0];
            res[j][1] = points[i][1];
            j++;
        }
        return res;
    }
}