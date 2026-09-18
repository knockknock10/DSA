class Solution {
    public boolean isPalindrome(int x) {
        int orig=x;
        int r=0;
        while(x>0){
            int n = x%10;
            r=r*10+n;
            x=x/10;
        }
        return r==orig;
    }
}
