class Solution {
    public int firstStableIndex(int[] a, int k) {
        int n = a.length;
        int[] s = new int[n];
        s[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            s[i] = Math.min(a[i], s[i + 1]);
        }
        
        int x = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            x = Math.max(x, a[i]);
            if ((long) x - s[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
