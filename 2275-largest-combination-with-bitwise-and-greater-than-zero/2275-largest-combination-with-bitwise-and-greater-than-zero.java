class Solution {
    public int largestCombination(int[] candidates) {
        int[] binarySetCount = new int[32];
        for(int i=0;i<binarySetCount.length;i++) {
            for(int c: candidates) {
                if(((c>>i) & 1) == 1)
                    binarySetCount[i]++;
            }
        }
        int ans = 0;
        for(int i=0;i<binarySetCount.length;i++) 
            ans = Math.max(ans, binarySetCount[i]);
        return ans;
    }
}