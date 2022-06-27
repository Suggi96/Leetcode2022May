class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0) {
            neg = true;
            x = Math.abs(x);
        }
        long revNum = 0;
        while(x>0) {
            int digit = x % 10;
            revNum = (10 * revNum) + digit;
            x = x/10;
        }
        if(revNum>Integer.MAX_VALUE) return 0;
        return neg==true? (int)(-1 * revNum) : (int)(revNum);
    }
}