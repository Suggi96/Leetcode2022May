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
        if(maxi%2==0)
            return maxi/2;
        else
            return (maxi+1)/2;
    }
}