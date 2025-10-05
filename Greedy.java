public static void minabsdi(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int mindiff = 0;
        for (int i = 0; i < a.length; i++) {
            mindiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("min absoulute pair is : " + mindiff);
}


// MAximum length chain of pairs T.C(O(nlogn))
    public static void maxchain() {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(pairs, Comparator.comparing(o -> o[1]));

        int chainlen = 1;
        int chainend = pairs[0][1];// lastselected pair end //chain end

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainend) {
                chainlen++;
                chainend = pairs[i][1];
            }
        }
        System.out.println("max length of chain pair : " + chainlen);
    }



publice static void main(String args[]){
    int a[]={4,1,8,7};
    int b[]={2,3,6,5};
    minabsdi(a,b);
    //ans:6
        maxhcain();//ans 3

}
