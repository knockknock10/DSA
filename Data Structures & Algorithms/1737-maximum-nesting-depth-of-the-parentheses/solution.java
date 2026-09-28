class Solution {
    public int maxDepth(String s) {
        int ans = 0,dept = 0;
        for(char c:s.toCharArray()){
            dept+=c=='(' ? 1 : c==')' ? -1:0;
            ans = Math.max(ans,dept);
        }
        return ans;
    }
}
