class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int i=0;
        String result="";
        Map <String,String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
        map.put(pair.get(0), pair.get(1));
    }
        
        while(i<s.length()){
            char ch = s.charAt(i);
            if (ch == '('){
                i++;
                String temp="";
                while(s.charAt(i)!=')'){
                temp += s.charAt(i);
                i++;
                }
                 if(map.containsKey(temp)){
                    result+=map.get(temp);
                }
                else{
                    result+="?";
                }
             i++;
            }else{
             result+=s.charAt(i);
                i++;}
        }
        return result;
        
    }
}