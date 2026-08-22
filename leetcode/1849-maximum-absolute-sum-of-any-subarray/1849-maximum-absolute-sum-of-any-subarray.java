class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            min = Math.min(min + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(max, Math.abs(min)));
        }

        return ans;
    }
}