class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (stack.isEmpty() || stack.peek().ch != ch) {
                stack.push(new Pair(ch, 1));
            } 
            else {
                stack.peek().count++;

                if (stack.peek().count == k) {
                    stack.pop();
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair p = stack.pop();

            for (int i = 0; i < p.count; i++) {
                ans.append(p.ch);
            }
        }

        return ans.reverse().toString();
    }
}