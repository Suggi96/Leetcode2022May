class Solution {
    int time = 0;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
     //   Arrays.fill(adj, new ArrayList<>());
        //creating adj list array
        for(List<Integer> edge: connections) {
            int a = edge.get(0);
            int b = edge.get(1);
            adj[a].add(b); //make connection a-> b
            adj[b].add(a); //make connection b->a
        }
        boolean[] visited = new boolean[n];
        int[] timeStamp = new int[n];
        
        
        int vertex = 0;
        int prev = -1;
        dfs(adj, visited, timeStamp, vertex, prev);
        return res;
    }
    private void dfs(List<Integer>[] adj, boolean[] visited, int[] timeStamp, int vertex, int prev) {
        visited[vertex] = true;
        timeStamp[vertex] = time++;
        int curtimeStamp = timeStamp[vertex]; //useful to check with neighbouring nodes time stamp
        
        for(int v: adj[vertex]) { //v is reachable vertices from vertex
            if(v==prev) continue;
            
            if(!visited[v])
                dfs(adj, visited, timeStamp, v, vertex);
            
            timeStamp[vertex] = Math.min(timeStamp[vertex], timeStamp[v]);
            
            if(curtimeStamp < timeStamp[v])
                res.add(Arrays.asList(vertex, v));
        }
    }
}