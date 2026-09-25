import java.util.*;

class Solution {

    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    // Handles union: A,B,C
    private Set<String> parseExpression() {
        Set<String> result = parseTerm();

        while (index < expression.length() &&
               expression.charAt(index) == ',') {

            index++; // skip ','

            Set<String> next = parseTerm();
            result.addAll(next);
        }

        return result;
    }

    // Handles concatenation: ABC or {a,b}{c,d}
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()) {

            char ch = expression.charAt(index);

            // End of current brace
            if (ch == '}' || ch == ',') {
                break;
            }

            Set<String> next = parseFactor();

            result = combine(result, next);
        }

        return result;
    }

    // Handles a single letter or {...}
    private Set<String> parseFactor() {

        char ch = expression.charAt(index);

        // { ... }
        if (ch == '{') {
            index++; // skip '{'

            Set<String> result = parseExpression();

            index++; // skip '}'

            return result;
        }

        // Single lowercase letter
        index++;

        Set<String> result = new HashSet<>();
        result.add(String.valueOf(ch));

        return result;
    }

    // Cartesian product + concatenation
    private Set<String> combine(Set<String> first,
                                Set<String> second) {

        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}