class Solution {
    public int longestStrChain(String[] words) {
        int ans = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        for(String word: words) {
            int best = 0;
            for(int i=0;i<word.length();i++) {
                String pred = word.substring(0, i) + word.substring(i+1, word.length());
                int val = dp.getOrDefault(pred, 0);
                best = Math.max(best, val+1);
            }
            dp.put(word, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}