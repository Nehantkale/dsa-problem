class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> extraOpenBrackets = new Stack<>();
        Stack<Integer> astrick = new Stack<>();
          for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                extraOpenBrackets.push(i);
            }else if (ch=='*'){
                astrick.push(i);
            }else{
                //closing brackets
                if(!extraOpenBrackets.isEmpty()){
                    extraOpenBrackets.pop();
                } else if(!astrick.isEmpty()){
                    astrick.pop();
                } else {
                    return false;
                }
            }
          }
          while(!extraOpenBrackets.isEmpty()){
            if(astrick.isEmpty()){
                return false;
            }
            if(extraOpenBrackets.pop()>astrick.pop()){
                return false;
            }
          }
          return extraOpenBrackets.isEmpty();
    }
}