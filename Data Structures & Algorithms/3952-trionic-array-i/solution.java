class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] > nums[i-1]){
            i++;
        }
        if (i == 1 || i == nums.length) return false;
        while (i < nums.length && nums[i] < nums[i-1]){
            i++;
        }
        if (i == nums.length) return false;
        while (i < nums.length && nums[i] > nums[i-1]){
            i++;
        }
        return (i == nums.length) ? true:false;
    }
}
