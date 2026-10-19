class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> arr=new ArrayList<>();
        
        for(int i =0;i<n;i++){
            if(nums[i]==target){
                arr.add(i);
            }
        }
        return arr;

        
    }
}