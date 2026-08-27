class Solution {
    public int dominantIndex(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;
        int a=0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]>largest){
                secondlargest=largest;
                largest=nums[i];
                a=i;
            }
            else if (nums[i]>secondlargest){
                secondlargest=nums[i];
            }
        }
        if(largest >= secondlargest*2)
        {
            return a;
        }
      return -1;
    }
}