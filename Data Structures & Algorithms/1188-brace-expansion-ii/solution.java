class Solution {
    TreeSet<String> ans = new TreeSet<>();

    void dfs(String s) {
        int r = s.indexOf('}');

        // No braces left
        if (r == -1) {
            ans.add(s);
            return;
        }

        // Find matching '{'
        int l = s.lastIndexOf('{', r);

        String left = s.substring(0, l);
        String right = s.substring(r + 1);

        // Content inside { }
        String inside = s.substring(l + 1, r);

        for (String part : inside.split(",")) {
            dfs(left + part + right);
        }
    }

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(ans);
    }
}
