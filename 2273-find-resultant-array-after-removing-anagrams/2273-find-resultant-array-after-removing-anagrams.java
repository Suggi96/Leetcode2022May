class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<words.length;i++) {
            int top = st.peek();
            String s1 = words[top];
            String s2 = words[i];
            if(isEqual(s1, s2)) {
            //    System.out.println("yes");
                continue;
            }
                
            else
                st.push(i);
        }
        List<String> list = new ArrayList<>();
        for(int i: st) {
            list.add(words[i]);
        }
        return list;
    }
    private boolean isEqual(String s1, String s2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(char c: s1.toCharArray())
            f1[c - 'a']++;
        for(char c: s2.toCharArray()) 
            f2[c - 'a']++;
        return Arrays.equals(f1, f2);
    }
}