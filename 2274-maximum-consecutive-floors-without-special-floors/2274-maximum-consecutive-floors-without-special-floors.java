class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int start = bottom;
        int end = top;
        int ans = 0;
        for(int i=0;i<special.length;i++) {
            int Endfloor = special[i];
            int remaining = Endfloor - start;
            ans = Math.max(ans, remaining);
            start = Endfloor + 1;
        }
        ans = Math.max(ans, end - special[special.length-1]);
        return ans;
    }
}