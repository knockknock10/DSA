public static void minabsdi(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int mindiff = 0;
        for (int i = 0; i < a.length; i++) {
            mindiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("min absoulute pair is : " + mindiff);
}
publice static void main(String args[]){
    int a[]={4,1,8,7};
    int b[]={2,3,6,5};
    minabsdi(a,b);
    //ans:6

}
