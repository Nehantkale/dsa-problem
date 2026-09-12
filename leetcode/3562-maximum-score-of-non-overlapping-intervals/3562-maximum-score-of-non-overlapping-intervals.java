import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, index;

        Interval(int l, int r, int w, int index) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.index = index;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Result[][] dp;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        // Convert List<List<Integer>> to Interval[]
        for (int i = 0; i < n; i++) {

            List<Integer> x = intervals.get(i);

            arr[i] = new Interval(
                x.get(0),
                x.get(1),
                x.get(2),
                i
            );
        }

        // Sort by starting position
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }

            return Integer.compare(a.r, b.r);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        // Convert List<Integer> to int[]
        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        // Required lexicographical order
        Arrays.sort(result);

        return result;
    }

    private Result solve(int i, int k) {

        if (i == n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Skip current interval
        Result skip = solve(i + 1, k);

        // Take current interval
        int next = findNext(i);

        Result nextResult = solve(next, k - 1);

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(arr[i].index);
        takeIndices.addAll(nextResult.indices);

        Result take = new Result(
            arr[i].w + nextResult.score,
            takeIndices
        );

        dp[i][k] = better(take, skip);

        return dp[i][k];
    }

    private int findNext(int i) {

        int target = arr[i].r;

        int low = i + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Strictly greater because boundaries overlap
            if (arr[mid].l > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private Result better(Result a, Result b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller
        List<Integer> x = new ArrayList<>(a.indices);
        List<Integer> y = new ArrayList<>(b.indices);

        Collections.sort(x);
        Collections.sort(y);

        int size = Math.min(x.size(), y.size());

        for (int i = 0; i < size; i++) {

            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i) ? a : b;
            }
        }

        return x.size() <= y.size() ? a : b;
    }
}