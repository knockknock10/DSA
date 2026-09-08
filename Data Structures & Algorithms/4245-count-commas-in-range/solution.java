class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        int t = 1000;
        while (n >= t) {
            totalCommas += (n-t+1);
            t *= 1000;
        }
        return totalCommas;
    }
}
