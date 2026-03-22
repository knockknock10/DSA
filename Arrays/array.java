package Arrays;

public class array {
    //1)find the indx of ele Tc O(n)
    public static int idx(int key){
        int arr[] = {2,4,6,8,10,12,14};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    //2) find the largest and smallest number
    public static void larg(){
        int arr[] = {1,2,8,4,3};
        int n = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>n){
                n = arr[i];
            }
        }System.out.println("largest no :"+n);
    }
    //3) find the smallest 
    public static void small(){
        int arr[] = {1,2,8,4,3};
        int n = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<n){
                n = arr[i];
            }
        }System.out.println("smallest no :"+n);
    }
    public static void main(String[] args) {
        System.out.println(idx(8));
        larg();
        small();
    }
}
