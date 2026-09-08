class Solution {
    public int countCommas(int n) {
        int num=0;
        if(n<1000){
            return 0;
        }
        else{
             num=n-999;

        }
        return num;
    }
}