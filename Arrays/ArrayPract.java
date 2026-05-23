public class ArrayPract {
    // 26. Remove Duplicates from Sorted Array TC O(n) SC O(1)
    public static int removeDuplicates(int[] nums){
        if(nums.length==0) return 0;
        int i =0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i+1;
    }
    //88. Merge Sorted Array Tc (m+n) Sc O(1)
    public static void merge(int[] nums1,int m,int[] nums2,int n ){
        int i = m-1;
        int j = n-1;
        int x = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[x] = nums1[i];
                i--;
                x--;
            }else{
                nums1[x]= nums2[j];
                j--;
                x--;
            }
        }//for j out of bound
        while(j>=0){
            nums1[x] = nums2[j];
            j--;
            x--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}