class Solution {
    public int minQueenMoves(int[] a, int[] b) {
        int c = a[0],d = a[1],e =b[0],f=b[1];
        if(c==e && d==f) return 0;
        if(c==e || d==f || Math.abs(c-e)==Math.abs(d-f)) return 1;
        return 2;
    }
}
