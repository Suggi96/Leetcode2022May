class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> hs = new HashSet<>();
        for(int i: nums)
            hs.add(i);
        int longestStreak = 0;
        for(int el: hs) {
            if(!hs.contains(el-1)) {
                int curNum = el;
                int curStreak = 1;
                while(hs.contains(curNum+1)) {
                    curNum += 1;
                    curStreak += 1;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}