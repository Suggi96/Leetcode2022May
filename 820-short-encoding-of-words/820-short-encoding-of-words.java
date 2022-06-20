class Solution {
    public int minimumLengthEncoding(String[] words) {
          HashSet<String> hashset = new HashSet<>();
		
		// Add all the words in the hashset
        for(String word : words) {
            hashset.add(word);
        }
        
        for(String word : words) {
			// Remove every suffix string from each word from the hashset except for the full word
			// Because a word and one of its suffix string can be encoded into a single string
            for(int i = word.length() - 1; i > 0; i--) {
                String substring = word.substring(i, word.length());
                if(hashset.contains(substring)) hashset.remove(substring);
            }
        }
        
        int length = 0;
        for(String word : hashset) length += word.length();
		
		// length for character count and hashset size for the required number of #
        return length + hashset.size();
    }
}