class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] vacancy = new int[n];
        for(int i=0;i<n;i++) {
            vacancy[i] = capacity[i] - rocks[i];
        } 
        int count = 0;
        Arrays.sort(vacancy);
        for(int i=0;i<n;i++) {
            if(vacancy[i]==0) {
                count++;
                continue;
            }
            else {
                if(additionalRocks>=vacancy[i]) {
                    additionalRocks -= vacancy[i];
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}