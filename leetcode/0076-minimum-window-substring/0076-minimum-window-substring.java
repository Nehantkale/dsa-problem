class Solution {
    public String minWindow(String s, String t) {
        int freq[]=new int[256];
        for(char ch : t.toCharArray())
        {
            freq[ch]++;
        }
        int low = 0;
        int high = 0;
        int count = t.length();
        int start = 0;
        int res = Integer.MAX_VALUE;
        while(high<s.length()){
            char ch = s.charAt(high);
            if(freq[ch]>0){
                count--;
            }
            freq[ch]--;
            high++;
            while(count==0)
            {
                if(high - low < res){
                    res=high-low;
                    start=low;
                }
                char lowChar=s.charAt(low);
                freq[lowChar]++;
                if(freq[lowChar] > 0){
                    count++;
                }
                low++;
            }
        }
        if(res==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+res);
        
    }
}