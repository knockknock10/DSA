class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1){return 1;}
        // return climbStairs(n-1)+climbStairs(n-2);
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }    
        return dp[n];
    
    }
}
