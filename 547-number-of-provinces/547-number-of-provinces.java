class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, int curVertex, boolean[] visited) {
        if(visited[curVertex])
            return;
        
        visited[curVertex] = true;
        int[] neigh = isConnected[curVertex];
        for(int i=0;i<neigh.length;i++) {
            if(neigh[i]==1)
                dfs(isConnected, i, visited);
        }
        return;
    }
    
}