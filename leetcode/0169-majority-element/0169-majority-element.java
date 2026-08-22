class Solution {
    public int majorityElement(int[] nums) {
        int candidates=0;
        int votes=0;
        for(int num : nums){
            if(votes==0){
                candidates=num;
            }
            if(num==candidates){
                votes++;
            }
            else{
                votes--;
            }
        }
        return candidates;
        
    }
}