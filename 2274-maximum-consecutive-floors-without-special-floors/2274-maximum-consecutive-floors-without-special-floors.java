class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int ans = 0;
        Arrays.sort(special);
        int start = bottom;
        int end = top;
        for(int i=0;i<special.length;i++) {
            int curFloor = special[i];
            int diff = curFloor - start;
            ans = Math.max(ans, diff);
            start = curFloor + 1;
        }
        ans = Math.max(ans, end - special[special.length-1]);
        return ans;
    }
}