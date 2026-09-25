class Solution {
    public boolean isPalindrome(String s) {
        String sa = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = sa.length();
        for(int i=0;i<n/2;i++){
            if(sa.charAt(i)!=sa.charAt(n-i-1)) return false;
        }
        return true;
    }
}
