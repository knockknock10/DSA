class Solution {
    public List<Integer> goodDaysToRobBank(int[] s, int t) {
        List<Integer> an = new ArrayList<>();
        int n = s.length,cnt = 0;
        int[] pre = new int[n];
        int[] suff = new int[n];
        for(int i=1;i<n;i++){
            if(s[i]<=s[i-1]) cnt++;
            else cnt = 0;
            pre[i] = cnt;
        }
        cnt = 0;
        for(int i=n-2;i>=0;i--){
            if(s[i]<=s[i+1]) cnt++;
            else cnt = 0;
            suff[i] = cnt;
        }
        for(int i=0;i<n;i++){
            if(pre[i]>=t && suff[i]>=t){
                an.add(i);
            }
        }
        return an;
    }
}
