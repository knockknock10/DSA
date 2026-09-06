class Solution {
    int n;
    int m;
    Integer dp[][];
    public int numDistinct(String s, String t) {
         n=s.length();
         m=t.length();
         dp=new Integer[n+1][m+1];
        return helper(s,t,0,0,new StringBuilder());
        }
    
    public int helper(String s,String t,int idx,int i,StringBuilder sb){
        if(i==m){
            if(sb.toString().equals(t)) return 1;
            return 0;
            
        }
        if(idx==n) return 0;
        if(dp[idx][i]!=null) return dp[idx][i];
        int take=0;
        int skip=0;
        if(s.charAt(idx)==t.charAt(i)){
                 sb.append(s.charAt(idx));
              take=   helper(s,t,idx+1,i+1,sb);
                 sb.deleteCharAt(sb.length()-1);
        }
        
          skip=  helper(s,t,idx+1,i,sb);
        
        return dp[idx][i]=take+skip;
    }


}
