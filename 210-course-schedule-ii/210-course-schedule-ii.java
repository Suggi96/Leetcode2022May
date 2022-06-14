class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(prerequisites, numCourses);
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            for(int curNeigh: graph.get(i)) {
                indegree[curNeigh] +=1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<indegree.length;i++)
            if(indegree[i]==0)
                q.add(i);
        boolean[] visited = new boolean[numCourses];
        while(!q.isEmpty()) {
            int curCourse = q.remove();
            if(visited[curCourse]==true)
                continue;
            
            visited[curCourse] = true;
            order.add(curCourse);
            
            for(int curNeigh: graph.get(curCourse)) {
                indegree[curNeigh] -= 1;
                
                if(indegree[curNeigh]==0)
                    q.add(curNeigh);
            }
        }
        if(order.size()!=numCourses)
            return new int[0];
        int[] res = new int[numCourses];
        for(int i=0;i<res.length;i++) {
            res[i] = order.get(i);
        }
        return res; 
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