class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n-- == 1) return List.of("()");
        dfs(n, n, "(");

        return res;
    }

    private void dfs(int O, int C, String s) {
        if (O == 0 && C == 0) {
            res.add(s + ")");
            return;
        }

        if (O > 0)
            dfs(O - 1, C, s + "(");

        if (C >= O)
            dfs(O, C - 1, s + ")");
    }
}
