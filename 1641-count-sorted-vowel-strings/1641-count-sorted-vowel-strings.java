class Solution {
    public int countVowelStrings(int n) {
        Integer[][] memo = new Integer[n + 1][5];
        return dp(n, 0, memo);
    }

    int dp(int n, int i, Integer memo[][]) {
        if (n == 0) return 1; // Found a valid answer
        if (i == 5) return 0; // Reach to length of vowels [a, e, i, o, u]
        if (memo[n][i] != null) return memo[n][i];
        
        int pickCurChar = dp(n, i+1, memo);
        int skipCurChar = dp(n-1, i, memo);
        int ans = pickCurChar + skipCurChar;
        memo[n][i] = ans;
        return memo[n][i];
    }
}