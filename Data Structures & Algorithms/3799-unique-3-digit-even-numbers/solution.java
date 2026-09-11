class Solution {
    public int totalNumbers(int[] digits) {
        int[] f= new int[10];
        for(int i:digits) f[i]++;
        int ans = 0;
        for(int i=1;i<=9;i++){
            if(f[i]==0) continue;
            f[i]--;
            for(int j=0;j<=9;j++){
                if(f[j]==0) continue;
                f[j]--;
                for(int k=0;k<=8;k+=2){
                    if(f[k]>0) ans++;
                }
                f[j]++;
            }
            f[i]++;
        }return ans;
    }
}
