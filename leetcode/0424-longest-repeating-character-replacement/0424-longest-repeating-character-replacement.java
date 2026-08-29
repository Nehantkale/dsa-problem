class Solution {
    public int characterReplacement(String s, int k) {
        int low=0;
        int n = s.length();
        int maxlen = 0;
        int maxfreq=0;
        int[] freq =new int[26];
        for(int high=0;high<n;high++){
            char c = s.charAt(high);
            freq[c- 'A']++;
            maxfreq=Math.max(maxfreq,freq[c-'A']);
            int windowSize=high-low+1;
            if(windowSize-maxfreq>k){
                freq[s.charAt(low)-'A']--;
                low++;
            }
            maxlen = Math.max(maxlen,high-low+1);
        }
        return maxlen;
        
    }
}