class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int r = 0, c = 0;
        while(r<n && c<n) {
            if(grid[r][c]==0) return false;
            grid[r][c] = 0;
            r++;
            c++;
        }
        r =  0;
        c = n-1;
        while(r<n && c>=0) {
            if(r==c &&  grid[r][c]==0) {
                r++;
                c--; 
                continue;
            }
            if(grid[r][c]==0) return false;
            grid[r][c] = 0;
            r++;
            c--;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0) return false;
            } 
        }
        return true;
    }
}