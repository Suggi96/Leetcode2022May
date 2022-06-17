class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = buildgraph(times, n);
        //minheap to maintain vertices and its corresponding time
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>( (a, b) -> a.getValue() - b.getValue());
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> curPair = pq.remove();
            int curVertex = curPair.getKey();
            int curTime = curPair.getValue();
            
            if(distance[curVertex]!=-1)
                continue;
            
            distance[curVertex] = curTime;
            ArrayList<ArrayList<Integer>> curNeigh = graph.get(curVertex);
            for(ArrayList<Integer> current: curNeigh) {
                int adjNeigh = current.get(0);
                int time = current.get(1);
                pq.add(new Pair(adjNeigh, curTime + time));
            }
            
        }
        int reqTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            if(distance[i]==-1)
                return -1;
            else {
                reqTime = Math.max(reqTime, distance[i]);
            }
        }
        return reqTime;
        
    }
    private ArrayList<ArrayList<ArrayList<Integer>>> buildgraph(int[][] times, int n) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<ArrayList<Integer>>());
        
        for(int[] edge: times) {
            int source = edge[0];
            int dest = edge[1];
            int time = edge[2];
            ArrayList<Integer> neigh = new ArrayList<>();
            neigh.add(dest);
            neigh.add(time);
            graph.get(source).add(neigh);
        }
        return graph;
    }
}