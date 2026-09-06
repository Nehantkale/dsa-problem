class Solution {
    public boolean canWinNim(int n) {

        int t=n%4;
        //int d=t%4;
        if(t==0){
            return false;
        }
        return true;
        
    }
}