package AllQues;

public class arrayques {
    //Pairs
    public static void Pairs(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
         int arr[] = {1,5,9,2,3};
        Pairs(arr);
    }
    
}
