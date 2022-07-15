class Solution {
    public String reverseVowels(String s) {
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>();
        for(char c: vowels)
            set.add(c);
        int i = 0, j = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(i<j) {
            while(i<j && !set.contains(s.charAt(i))) i++;
            while(i<j && !set.contains(s.charAt(j))) j--;
                char temp = s.charAt(i);
                sb.replace(i, i+1, s.charAt(j)+"");
                sb.replace(j, j+1, temp+"");
            
            i++;
            j--;
        }
        return sb.toString();
    }
}