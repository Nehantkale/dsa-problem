class Solution {
    public boolean isPalindrome(int x) {
        int y =x;
        int value=0;
        while(y!=0){
        int divide = y%10;
        value=(value*10)+divide;
        y=y/10;
        }
        if(value==x){
            if(x<0){return false;}
            else return true;
        }
        return false;
    }
}