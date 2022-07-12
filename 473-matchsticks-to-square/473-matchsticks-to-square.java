class Solution {
    public boolean makesquare(int[] ms) {
        int sum = 0;
        for(int i: ms)
            sum += i;
        if(sum%4!=0) return false;
        boolean[] visited = new boolean[ms.length];
        return backtrack(ms, 4, visited, 0, 0, sum/4);
    }
    private boolean backtrack(int[] ms, int subsets, boolean[] visited, int curIdx, int curSum, int targetSum) {
        if(subsets==0)
            return true;
        if(curSum>targetSum)
            return false;
        if(curSum==targetSum)
            return backtrack(ms, subsets-1, visited, 0, 0, targetSum);
        
        for(int i=curIdx;i<ms.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(backtrack(ms, subsets, visited, i+1, curSum+ms[i], targetSum))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}