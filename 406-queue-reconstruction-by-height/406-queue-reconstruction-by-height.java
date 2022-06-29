class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0]==b[0]? a[1]-b[1]: b[0]-a[0]); //sort array in des order of their height.
                                                                        //if equal sort in sort in asc order of k
        List<int[]> list = new ArrayList<>();
        for(int[] p: people) {
            int index = p[1];
            list.add(index, p);
        }
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for(int[] arr: list) {
            ans[i][0] = arr[0];
            ans[i][1] = arr[1];
            i++;
        }
        return ans;
    }
}