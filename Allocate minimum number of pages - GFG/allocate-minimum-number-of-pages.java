// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>A.length) return -1;
        int low = A[0];
        int high = 0;
        for(int i: A) {
            low = Math.min(low, i);
            high += i;
        }
        int res = -1;
        while(low<=high) {
            int mid = (low + high) >> 1;
            if(isPossible(A, mid, M)) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
        private static boolean isPossible(int[] A, int barrier, int students) {
        int cnt = 1;
        int sumAllocated = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>barrier) return false;
            if(sumAllocated+A[i] > barrier) {
                sumAllocated = A[i];
                cnt++;
            }
            else {
                sumAllocated += A[i];
            }
        }
        if(cnt > students)
            return false;
        return true;
    }
};