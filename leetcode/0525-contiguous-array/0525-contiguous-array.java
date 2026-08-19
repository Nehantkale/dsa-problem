class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int one=0;
        int zero=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
          {  zero++;}
            else
            {one++;}
            int diff=zero-one;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
            if (!map.containsKey(diff)) {
    map.put(diff, i); 
    } else {
    int idx = map.get(diff);
    int len = i - idx;
    res = Math.max(res, len);
    } 
        }return res;
    }
}