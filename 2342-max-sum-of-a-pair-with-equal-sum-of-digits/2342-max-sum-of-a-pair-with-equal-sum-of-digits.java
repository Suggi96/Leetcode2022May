class Solution {
    public int maximumSum(int[] nums) {
        //digitSum, el
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for(int num: nums) {
            int sum = findSum(num);
            if(!map.containsKey(sum)) {
                map.put(sum, num);
            }
            else {
                ans = Math.max(ans, map.get(sum)+num);
                map.put(sum, Math.max(map.get(sum), num));
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