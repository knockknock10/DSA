class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        fwd(s, res, 0, 0);

        return res;
    }

    private void fwd(String s, List<String> res, int li, int lj) {
        int bal = 0;

        for (int i = li; i < s.length(); i++) {
            if (s.charAt(i) == '(') bal++;
            if (s.charAt(i) == ')') bal--;

            if (bal >= 0) continue;

            for (int j = lj; j <= i; j++)
                if (s.charAt(j) == ')' && (j == lj || s.charAt(j - 1) != ')'))
                    fwd(s.substring(0, j) + s.substring(j + 1), res, i, j);

            return;
        }

        bwd(s, res, s.length() - 1, s.length() - 1);
    }

    private void bwd(String s, List<String> res, int ri, int rj) {
        int bal = 0;

        for (int i = ri; i >= 0; i--) {
            if (s.charAt(i) == ')') bal++;
            if (s.charAt(i) == '(') bal--;

            if (bal >= 0) continue;

            for (int j = rj; j >= i; j--)
                if (s.charAt(j) == '(' && (j == rj || s.charAt(j + 1) != '('))
                    bwd(s.substring(0, j) + s.substring(j + 1), res, i - 1, j - 1);

            return;
        }

        res.add(s);
    }
}
