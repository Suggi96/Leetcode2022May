class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int)1e9 + 7;
        int m = horizontalCuts.length, n = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0]-0, h - horizontalCuts[m-1]);
        int maxW = Math.max(verticalCuts[0]-0, w - verticalCuts[n-1]);
        
        for(int i=1;i<m;i++) {
            int curH = horizontalCuts[i] - horizontalCuts[i-1];
            maxH = Math.max(maxH, curH);
        }
        
        for(int i=1;i<n;i++) {
            int curW = verticalCuts[i] - verticalCuts[i-1];
            maxW = Math.max(maxW, curW);
        }
        long ans = 1L *  maxH * maxW;
        
        return (int)(ans % mod);
    }
}