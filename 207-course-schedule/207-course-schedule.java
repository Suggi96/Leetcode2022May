class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];
        Set<Integer> set = new HashSet<>();
        for(int curVertex=0; curVertex<numCourses; curVertex++) {
            if(visited[curVertex]==false && dfs(graph, curVertex, visited, set))
            return false;
        }
        return true;
        
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curVertex, boolean[] visited, Set<Integer> set) {
        visited[curVertex] = true;
        set.add(curVertex);
        
        ArrayList<Integer> neigh = adj.get(curVertex);
        for(int curNeigh: neigh) {
            if(visited[curNeigh]==false && dfs(adj, curNeigh, visited, set))
                return true;
            
            if(set.contains(curNeigh))
                return true;
        }
        set.remove(curVertex);
        return false;
    }
        private ArrayList<ArrayList<Integer>> buildGraph(int[][] prerequisites, int numCourses) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        for(int[] curEdges: prerequisites) {
            int u = curEdges[1];
            int v = curEdges[0];
            graph.get(u).add(v);
        }
        return graph;
    }
}