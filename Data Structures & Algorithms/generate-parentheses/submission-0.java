class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        int open = n, closed = n;
        List<String> res = new LinkedList<>();
        backtrack(open, closed, n, str, res);
        return res;
    }

    static void backtrack(int open, int closed, int n, StringBuilder str, List<String> res) {
        if (open == 0 && closed == 0) {
            res.add(str.toString());
            return;
        }
        if (open > 0) {
            str.append("(");
            open--;
            backtrack(open, closed, n, str, res);
            open++;
            str.deleteCharAt(str.length() - 1);
        }
        if (closed > open) {
            str.append(")");
            closed--;
            backtrack(open, closed, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
