class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        boolean insert = false;

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (!insert && newInterval[1] < start) {
                res.add(newInterval);
                insert = true;
            }
            if (!insert && newInterval[0] <= end) {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
                continue;
            }

            res.add(intervals[i]);
        }
        if (!insert) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }
}