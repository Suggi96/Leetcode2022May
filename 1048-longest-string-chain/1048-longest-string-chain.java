class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> memo = new HashMap<>();
        int ans = 0;
        for(String word: words) {
            int longestChainWithCurrentWord = 0;
            //generate all combinations of word by deleting a single char in word 
            for(int i=0;i<word.length();i++) {
                String predecessor  = word.substring(0, i) + word.substring(i+1, word.length());
                longestChainWithCurrentWord = Math.max(longestChainWithCurrentWord, memo.getOrDefault(predecessor, 0) +1);
            }
            memo.put(word, longestChainWithCurrentWord);
            ans = Math.max(ans, longestChainWithCurrentWord);
        }
        return ans;
    }
}