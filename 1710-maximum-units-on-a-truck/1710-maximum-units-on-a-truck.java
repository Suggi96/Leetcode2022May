class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)-> a[1]==b[1] ? b[0]-a[0] : b[1]-a[1]);
        int units = 0;
        for(int[] box: boxTypes) {
            int b = Math.min(box[0], truckSize);
            units += b * box[1];
            truckSize -= b;
            if(truckSize==0) break;
        }
        return units;
    }
}