class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;
        st.push(-1);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(')
                st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                }
                else {
                  int len = i - st.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
}