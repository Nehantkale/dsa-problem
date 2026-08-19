class Solution {
    public boolean detectCapitalUse(String word) {
        int a=0;
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))){
                a++;
            }
        }
        if(a==0 || a==word.length() || (a==1 && Character.isUpperCase(word.charAt(0)) ))
        {
            return true;
        }
        else 
        return false;
        
    }
}