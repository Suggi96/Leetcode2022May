class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int minCost = Integer.MAX_VALUE;
        Map<String, Integer> memo = new HashMap<>();
        //starting point can be from first row first col to first row last col.. ie 0,0 .... to 0,j
        for(int j=0;j<n;j++) {
            int ans = solve(grid, moveCost, 0, j, m, n, memo);
            minCost = Math.min(minCost, ans);
        }
        return minCost;
    }
    private int solve(int[][] grid, int[][] moveCost, int i, int j, int m, int n, Map<String, Integer> memo) {
        if(i==m-1)
            return grid[i][j];
        
        String key = i + "-" + j;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int curCost = Integer.MAX_VALUE;
        for(int move=0;move<n;move++) {
            int celValue = grid[i][j];
            int mc = moveCost[celValue][move];
            int cost = celValue + mc + solve(grid, moveCost, i+1, move, m, n, memo);
            curCost = Math.min(curCost, cost);
        }
        memo.put(key, curCost);
        return memo.get(key);
    }
}