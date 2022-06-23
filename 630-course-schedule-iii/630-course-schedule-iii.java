class Solution {
    public int scheduleCourse(int[][] courses) {
        //sort the courses based on lastDay in ascending order
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //maxHeap to store duration
        int time = 0;
        for(int[] course: courses) {
            //consider if current course <= lastDay
            if(course[0] <= course[1]) {
                //check if current course can be completed within lastDay
                if(course[0]+time <= course[1]) {
                    pq.offer(course[0]);
                    time += course[0];
                }
                //check if we can swap the course with highest duration to optimise our answer
                else {
                    if(pq.peek() > course[0]) {
                        time -= pq.poll();
                        pq.offer(course[0]);
                        time += course[0];
                    }
                }
            }
        }
        return pq.size();
    }
}