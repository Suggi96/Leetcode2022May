class Solution {
    public int minSwaps(String s) {
        int extra = 0, maxi = 0;
        for(char c: s.toCharArray()) {
            if(c==']')
                extra++;
            else
                extra--;
            maxi = Math.max(maxi, extra);
        }
        return (maxi + 1)/2;
    }
}