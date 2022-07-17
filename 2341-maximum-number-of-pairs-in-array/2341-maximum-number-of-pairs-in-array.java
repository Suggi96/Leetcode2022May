class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int pairs = 0, leftOver = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            pairs += e.getValue()/2;
            leftOver += e.getValue()%2;
        }
        res[0] = pairs;
        res[1] = leftOver;
        return res;
    }
}