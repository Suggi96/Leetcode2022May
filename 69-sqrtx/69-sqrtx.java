class Solution {
    public int mySqrt(int x) {
        long start = 0, end = x;
        long ans = -1;
        while(start<=end) {
            long mid = start + (end-start)/2;
            if(mid*mid==x)
                return (int)mid;
            
            if(mid*mid>x) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid+1;
            }
        }
        return (int)ans;
    }
}