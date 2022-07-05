class Solution {
    public long[] sumOfThree(long num) {
        long[] ans = new long[3];
        if(num==0) {
            return new long[]{-1,0,1};
        }
        if(num%3!=0)
            return new long[]{};
        
        
        long n = 1 + (num/3);
        return new long[]{n-2,n-1,n};
        
    }
}