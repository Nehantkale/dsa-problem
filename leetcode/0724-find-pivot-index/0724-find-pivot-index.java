class Solution {
    public int pivotIndex(int[] nums) {
         int left=0;
        int sum = Arrays.stream(nums).sum();
        for(int i=0;i<nums.length;i++){
            int right= sum-nums[i]-left;
            if(left==right){
                return i;
            }
            left+=nums[i];
        } return -1;
    }
}