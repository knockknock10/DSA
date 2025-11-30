class Solution {
    public int maxDistinct(String s) {
        boolean[] abs = new boolean[26];
        int cot = 0;
        int n = s.length();
        int l =0;
        while(l<n){
            int ix = s.charAt(l)-'a';
            if(!abs[ix]){
                abs[ix] = true;
                cot++;
            }
            l++;
        }
        return cot;
    }
}
