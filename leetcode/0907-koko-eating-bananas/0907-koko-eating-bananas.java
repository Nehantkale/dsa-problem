class Solution {

    long fun(int[] piles,int speed){
        long h = 0L;
        for(int i =0 ;i<piles.length;i++){
            h+=piles[i]/speed;
            if(piles[i]%speed != 0){
                h++;
            }
        }
        return h;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i =0;i<piles.length;i++){
           high = Math.max(high, piles[i]);
        }
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            long hours=fun(piles,guess);
            if(hours>h){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
        
    }
}