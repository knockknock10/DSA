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
    //4)binary search O(logn)
    public static int binary(int arr[],int key){
        int start=0;
        int end = arr.length;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                return mid;
            }if(arr[mid]>key){
                start=mid-1;
            }else{
                start=mid+1;
            }
        }return -1;
    }
    //5)Reverse an array
    public static void rev(int arr[]){
        int first = 0;
        int last = arr.length-1;
        while(first<last){
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println(idx(8));
        larg();
        small();
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(binary(arr, 4));
        rev(arr);
    }
}
