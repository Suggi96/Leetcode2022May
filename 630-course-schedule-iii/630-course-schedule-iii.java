class Solution {
    public int scheduleCourse(int[][] courses) {
        //sort the courses based on lastDay in ascending order
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //maxHeap to store duration
        int time = 0;
        for(int[] course: courses) {
           time += course[0];
            pq.offer(course[0]);
            if(time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}