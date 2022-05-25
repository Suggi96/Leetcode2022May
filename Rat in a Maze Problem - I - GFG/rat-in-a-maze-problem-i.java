// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        helper(grid, 0, 0, "", n, ans);
        return ans;
    }
    private static void helper(int[][] grid, int i, int j, String path, int n, ArrayList<String> ans) {
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]<=0)
            return;
        if(i==n-1 && j==n-1) {
            ans.add(path);
            return;
        }
        grid[i][j] = -1; //mark current cell as visited
        //d,l,r,u as we want answer in lexicographical order call helper in that order only
        
        //down
        helper(grid, i+1, j, path+"D", n, ans);
        //left
        helper(grid, i, j-1, path+"L", n, ans);
        //right
        helper(grid, i, j+1, path+"R", n, ans);
        //up
        helper(grid, i-1, j, path+"U", n, ans);
        
        grid[i][j] = 1; //backtracking step.. Undoing the change
        
        return;
    }
}