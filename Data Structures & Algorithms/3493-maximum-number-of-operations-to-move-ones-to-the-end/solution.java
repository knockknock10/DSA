class Solution {
    public int maxOperations(String s) {
        int res = 0,one =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }else if(i>0 && s.charAt(i-1)=='1'){
                res+=one;
            }
        }
        return res;
    }
}
