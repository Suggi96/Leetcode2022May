public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
               int count = 0;
        while(n!=0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
    private int toBinary(int n) {
        List<Integer> list = new ArrayList<>();
        while(n>0) {
            int rem = n%2;
            n = n/2;
            list.add(rem);
        }
        int count = 0;
        for(int i: list) {
            if(i==1)
                count++;
        }
        return count;
    }
}