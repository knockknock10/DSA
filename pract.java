public class pract {
    public static void sub(int nums[]){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                    System.out.print(nums[k]+" ");
                }System.out.println("sum :"+sum);
                min = Math.min(min, sum);
            }
           
            System.out.println("Min "+ min);
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        sub(arr);
    }
}
