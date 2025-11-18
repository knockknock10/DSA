class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n =bits.length;
        int i=0;
        while(i<n-1){
            i+=bits[i]+1;
        }
        return i==n-1;
    }
}
