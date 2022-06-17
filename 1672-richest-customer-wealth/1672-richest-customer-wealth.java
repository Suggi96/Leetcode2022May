class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxSum = -1;
        for(int i=0;i<accounts.length;i++) {
            int curSum = 0;
            for(int j=0;j<accounts[i].length;j++) {
                curSum += accounts[i][j];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}