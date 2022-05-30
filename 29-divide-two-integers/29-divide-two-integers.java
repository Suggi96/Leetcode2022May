class Solution {
    public int divide(int dividend, int divisor) {
        long res = 0;
        boolean neg = false;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if((dividend<0 && divisor>0) ||  (dividend>0 && divisor<0))
            neg = true;
        if(ldivisor==0 || ldividend<ldivisor)
            return 0;
        res = ldivide(ldividend, ldivisor);
        if(res>Integer.MAX_VALUE) {
            if(neg) 
                return Integer.MIN_VALUE;
            
            else 
                return Integer.MAX_VALUE;
        }
        else {
            if(neg)
                return (int)(-res);
            else
                return (int)(res);
        }
    }
    private long ldivide(long ldividend, long ldivisor) {
        //base case
        if(ldividend<ldivisor)
            return 0;
        long count = 1; //step quotient
        long sum = ldivisor; //step divisor
        while(2*sum<=ldividend) {
            sum = 2*sum;
            count = 2*count;
        }
        return count + ldivide(ldividend-sum, ldivisor);
    }
}