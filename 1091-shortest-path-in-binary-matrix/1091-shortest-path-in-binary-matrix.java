class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1)
            return -1;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1}); //x,y and cost
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] point = q.poll();
                if(point[0]==m-1 && point[1]==n-1)
                    return point[2];
                for(int[] d: dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==0) {
                        q.add(new int[]{r, c, point[2]+1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;
    }
}