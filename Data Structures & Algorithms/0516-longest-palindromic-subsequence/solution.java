class Solution {
    public  int lcs(String s1,String s2,int i1,int i2,Integer[][] dp){
        if(i1 == s1.length() || i2 == s2.length()) return 0;
        if(dp[i1][i2]!=null) return dp[i1][i2];
        
        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = 1+lcs(s1,s2,i1+1,i2+1,dp);
        }else{
            int cal1 = lcs(s1,s2,i1+1,i2,dp);
            int cal2 = lcs(s1,s2,i1,i2+1,dp);
            return dp[i1][i2] = Math.max(cal1,cal2);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = (new StringBuilder (s)).reverse().toString();
        Integer[][] dp = new Integer[n+1][n+1];
        return lcs(s,rev,0,0,dp);
    }
}
