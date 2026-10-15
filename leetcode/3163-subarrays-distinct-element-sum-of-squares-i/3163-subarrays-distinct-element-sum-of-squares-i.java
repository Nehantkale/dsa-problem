class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans =0;
        int n =nums.size();
        for(int i =0;i<n;i++){
            Set <Integer> present = new HashSet<>();
            for(int j =i;j<n;j++){
                present.add(nums.get(j));
                int unique =present.size();
                ans+=unique*unique;
            }
        }
        return ans;
    }
}