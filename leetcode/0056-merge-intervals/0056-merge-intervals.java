class Solution {
    public int[][] merge(int[][] intervals) {
         List<int[]> res = new ArrayList<>();
         int n = intervals.length;
         Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
         int start1=intervals[0][0];
         int end1=intervals[0][1];
         for(int i=1;i<n;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(end1 >= start2){
                end1 = Math.max(end1, end2);
            continue;
            }
             res.add(new int[]{start1, end1});
             start1=start2;
             end1=end2;

         }
          res.add(new int[]{start1, end1});
           return res.toArray(new int[res.size()][]);
    }
}