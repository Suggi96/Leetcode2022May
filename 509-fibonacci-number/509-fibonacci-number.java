class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return f(n, memo);
    }
    private int f(int n, HashMap<Integer, Integer> memo) {
        if(n==0 || n==1)
            return n;
        
        int key = n;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int a = f(n-1, memo);
        int b = f(n-2, memo);
        memo.put(key, a+b);
        return memo.get(key);
    }
}