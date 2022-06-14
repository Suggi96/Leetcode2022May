// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int curVertex=0;curVertex<V;curVertex++) {
            if(visited[curVertex]==false) 
                if(dfs(adj, curVertex, -1, visited)==true)
                    return true;
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int curVertex, int curParent, boolean[] visited) {
        visited[curVertex] = true;
        
        for(int curNeigh: adj.get(curVertex)) {
            if(visited[curNeigh]==false) {
                if(dfs(adj, curNeigh, curVertex, visited))
                    return true;
            }
            else if(curNeigh!=curParent) { //cycle is present
                return true;
            }
            else {
                continue;
            }
        }
        return false; //cycle not present
    }
}