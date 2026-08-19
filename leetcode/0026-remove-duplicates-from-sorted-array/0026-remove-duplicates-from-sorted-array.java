class Solution {
    public int removeDuplicates(int[] nums) {
        int off=0;
        int k=1;
        int check=1;
       int n = nums.length;
        while(check < n){
            if(nums[check]==nums[check-1]){
            check++;
            continue;}
            nums[off+1]=nums[check];
            off++;
            k++;
            check++;
        }return k ;
    }
}