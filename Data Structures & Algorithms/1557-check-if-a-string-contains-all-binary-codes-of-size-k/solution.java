class Solution {
    public boolean hasAllCodes(String s, int k) {
        int req = 1 << k;
        boolean[] seen = new boolean[req];
        int mask = req - 1;
        int hash = 0;

        for (int i = 0; i < s.length(); ++i) {
            hash = ((hash << 1) & mask) | (s.charAt(i) & 1);

            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                req--;
                if (req == 0) return true;
            }
        }

        return false;
    }
}
