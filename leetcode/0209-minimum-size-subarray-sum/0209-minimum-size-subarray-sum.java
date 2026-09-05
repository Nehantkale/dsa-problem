class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int sum=0;
        int result = Integer.MAX_VALUE;
        while(high<n){
            sum=sum+nums[high];
            while(sum>=target){
                int len = high-low+1;
                result=Math.min(result,len);
                sum=sum-nums[low];
                low++;
            }high++;

        }if(result==Integer.MAX_VALUE) result=0;
        return result;
        
    }
}