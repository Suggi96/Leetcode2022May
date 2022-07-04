class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] distribution = new int[n];
        Arrays.fill(distribution, 1);
        for(int i=0;i<n-1;i++) {
            if(ratings[i+1]>ratings[i]) {
                distribution[i+1] = distribution[i] + 1;
            }
        }
        for(int i=n-1;i>0;i--) {
            if(ratings[i-1]>ratings[i]) {
                if(distribution[i-1]<=distribution[i])
                    distribution[i-1] = distribution[i] + 1;
            }
        } 
        int total = 0;
        for(int i: distribution)
            total += i;
        return total;
    }
}