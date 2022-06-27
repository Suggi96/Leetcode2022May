class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num==0) return true;
        if(num%10==0) return false;
        int n1 = reverse(num);
        int n2 = reverse(n1);
        return n2==num;
    }
    private int reverse(int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            int bit = (n>>i) & 1;
            res = res | (bit << (31-i));
        }
        return res;
    }
}