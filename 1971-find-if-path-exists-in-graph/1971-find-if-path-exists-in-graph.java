class Solution {
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        dfs(graph, source, destination, visited);
        return found;
    }
    private void dfs(List<List<Integer>> graph, int source, int dest, boolean[] visited) {
        if(source==dest) {
            found = true;
            return;
        }

        visited[source] = true;
        List<Integer> neigh = graph.get(source);
        for(int v: neigh) {
            // if(v==dest) {
            //     found = true;
            //     break;
            // }
            if(!visited[v])
                dfs(graph, v, dest, visited);
        }
    }
        
    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) {
            g.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return g;
    }
}