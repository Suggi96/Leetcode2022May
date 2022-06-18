class WordFilter {
    HashMap<String, Integer> map = null;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        int index = 0;
        for(String word: words) {
            for(int i=0;i<=word.length();i++) {
                for(int j=0;j<=word.length();j++) {
                    String prefixAndsuffix = word.substring(0, i) + "#" + word.substring(j);
                    map.put(prefixAndsuffix, index);
                }
            }
            index++;
        }
    }
    
    public int f(String prefix, String suffix) {
        String queryString = prefix + "#" + suffix;
        if(map.containsKey(queryString))
            return map.get(queryString);
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */