class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for(int[] curTrust: trust) {
            int a = curTrust[0];
            int b = curTrust[1];
            inDegree[b] += 1;
            outDegree[a] += 1;
        }
        
        for(int judge=1;judge<=n;judge++) {
            if(inDegree[judge]==n-1 && outDegree[judge]==0)
                return judge;
        }
        return -1;
    }
}