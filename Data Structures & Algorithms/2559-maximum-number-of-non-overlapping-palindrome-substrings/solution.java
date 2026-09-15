class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;

        int res = 0;

        for (int i = 0; i <= n - k; i++) {
            if (check(s, i, i + k - 1)) {
                res++;
                i += k - 1;
            } else if (i < n - k && check(s, i, i + k)) {
                res++;
                i += k;
            }
        }

        return res;
    }

    boolean check(String s, int l, int r) {
        for (; l < r; l++, r--)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }
}
