class Solution {
    public int maxSum(List<Integer> nums, int k) {

        int mod = 1000000007;
        int[] count = new int[30];

        // Count the number of 1's at each bit position
        for (int num : nums) {

            for (int i = 0; i < 30; i++) {

                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        long ans = 0;

        while (k > 0) {

            long num = 0;

            for (int i = 0; i < 30; i++) {

                if (count[i] > 0) {
                    num = num | (1L << i);
                    count[i]--;
                }
            }

            ans = (ans + num * num) % mod;

            k--;
        }

        return (int) ans;
    }
}