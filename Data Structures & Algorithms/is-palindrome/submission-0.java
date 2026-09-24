class Solution {
    public boolean isPalindrome(String s) {
        String cl = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String rev = new StringBuilder(cl).reverse().toString();
        return cl.equals(rev);
    }
}
