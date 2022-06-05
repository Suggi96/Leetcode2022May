class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int curCity=0;curCity<n;curCity++) {
            if(visited[curCity]==false) {
                dfs(graph, visited, curCity, n);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int[][] graph, boolean[] visited, int v, int n) {
        if(visited[v]==true)
            return;
        visited[v] = true;
        int[] nodes = graph[v];
        for(int i=0;i<n;i++) {
            if(nodes[i]==1) 
                dfs(graph, visited, i, n);
        }
    }
}