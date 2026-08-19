class Solution {
    public int maxProductDifference(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1=0;
        int max2=0;
        for(int i : nums){
            if(i < min1){
                min2=min1;
                min1=i;
            }
            else if(i <min2){
                min2=i;
            }
            if(i>max1){
                max2=max1;
                max1=i;
            }
            else if(i>max2){
                max2=i;
            }
        }
        return (max1*max2)-(min1 * min2);
        
    }
}