class Solution {
    public int maxDepth(String s) {
        Stack <Integer> stack = new Stack<>();
      int current_depth=0;
      int max_depth=0;
      int n =0;
      while( n < s.length()){
        char ch = s.charAt(n);
        if(ch=='('){
            current_depth++;
        }
        if(ch==')'){
            current_depth--;
        }
        n++;
        max_depth=Math.max(max_depth,current_depth);

      }
      return max_depth;
    }
}