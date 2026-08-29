class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] freq = new int[2];
        int n = nums.length;
        int low=0;
        int maxlen=0;
        for(int high=0;high<n;high++)
        {
            int a = nums[high];
            freq[a]++;
            while(freq[0]>k){
                freq[nums[low]]--;
                low++;
            }
             maxlen = Math.max(maxlen,high-low+1);
        } return maxlen;
    }
}