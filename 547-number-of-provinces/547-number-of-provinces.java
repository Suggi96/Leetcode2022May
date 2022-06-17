class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                bfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
    private void bfs(int[][] isConnected, int curVertex, boolean[] visited) {
      Queue<Integer> q = new LinkedList<>();
      q.add(curVertex);
      while(!q.isEmpty()) {
          int curNode = q.remove();
          visited[curNode] = true;
          int[] arr = isConnected[curNode];
          for(int i=0;i<arr.length;i++) {
              if(visited[i])
                  continue;
              
              if(arr[i]==1)
                  q.add(i);
          }
      }
        
    }
    
}