class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = (i^s.charAt(i)) & 1;
        }
        return res;
    }
}
