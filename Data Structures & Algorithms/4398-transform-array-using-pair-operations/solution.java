class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long a = 0,b = 0;
        int[] s = source;
        for(int c = 0,d = s.length;c<d;c++){
            a+=s[c];
            b+=target[c];
        }
        return a ==b;
    }
}
