class Solution {
    public List<int[]> mergeOverlap(int[][] intervals) {
        // Code here // Code here
        List<int[]> result = new ArrayList<>();

        if (intervals.length == 0) return result;

        // Step 1: Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Add the first interval to the result
        int[] current = intervals[0];
        result.add(current);

        // Step 3: Iterate through the intervals
        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval
                current = interval;
                result.add(current);
            }
        }

        return result;
    }
}