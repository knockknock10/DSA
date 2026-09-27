class Solution {
    public int[] rearrangeArray(int[] a) {
        int[] b= new int[101];
        int[] c = new int[a.length];
        for(int d:a) b[d]++;
        int e =0;
        while(e<a.length){
            for(int f = 1;f<=100;f++){
                if(b[f]>0){
                    c[e++]=f;
                    b[f]--;
                }
            }
        }
        return c;
    }
}
