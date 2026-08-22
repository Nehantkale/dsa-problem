class Solution {
    public int maxProduct(int[] nums) {
        int i =0;
        int bestEnding=nums[0];
        int minEnding=nums[0];
        int ans =nums[0];
        for(i=1;i<nums.length;i++){
            int v1 = nums[i];
            int v2 = bestEnding * nums[i];
            int v3 = minEnding * nums[i];
            bestEnding=Math.max(v1,Math.max(v2,v3));
            minEnding=Math.min(v1,Math.min(v2,v3));
            ans=Math.max(ans,bestEnding);
        }
        return ans;
        
    }
}