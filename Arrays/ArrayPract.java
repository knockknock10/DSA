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
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}