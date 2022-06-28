class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        
        long res=0; 
        int prev=0;
        int[] count = new int[1];
        
        for(int v=0;v<n;v++) {
            if(!visited[v]) {
                dfs(graph, v, visited, count);
                long a = n - count[0];
                long b = count[0] - prev;
                prev = count[0];
                res += (a*b);
            }
        }
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> graph, int curVertex, boolean[] visited, int[] nodes) {
        visited[curVertex] = true;
        List<Integer> neigh = graph.get(curVertex);
        nodes[0]++;
        for(int n: neigh) {
            if(!visited[n]) 
                dfs(graph, n, visited, nodes);
        }
    }
}