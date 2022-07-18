class Solution {
    public int maximumSum(int[] nums) {
        //digitSum, el
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int i: nums) {
            int sum = findSum(i);
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            else {
                ans = Math.max(ans, map.get(sum)+i);
                map.put(sum, Math.max(map.get(sum), i));
            }
        }
        return ans;
    }
    private int findSum(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n%10;
            sum += digit;
            n = n/10;
        }
        return sum;
    }
}