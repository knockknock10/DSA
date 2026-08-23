class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int diff = 0;
        int q = 0;

        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?'){
                q++;
            }else{
                diff += num.charAt(i)-'0';
            }
        }

        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?'){
                q--;
            }else{
                diff -= num.charAt(i)-'0';
            }
        }

        return 2 * diff + 9 * q != 0;
    }
}
