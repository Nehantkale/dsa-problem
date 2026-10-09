class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // If need is odd, we need one ')' to close the previous expectation
                if (need % 2 != 0) {
                    res++;
                    need--;
                }
                need += 2; // Each '(' requires two ')'
            } else {
                need--;
                // If need goes below 0, we have an extra ')' with no matching '('
                if (need < 0) {
                    res++;      // Insert a '('
                    need += 2;  // This ')' now pairs with the inserted '(' (leaving need as 1)
                }
            }
        }
        return res + need;
    }
}