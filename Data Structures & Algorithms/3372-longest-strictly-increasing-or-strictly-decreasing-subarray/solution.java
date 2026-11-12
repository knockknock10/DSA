class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incl = 1;
        int decl = 1;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                incl++;
                decl =1;
            }
            else if(nums[i-1]>nums[i]){
                decl++;
                incl = 1;
            }else{
                incl = 1;
                decl = 1;
            }
            count = Math.max(count, Math.max(incl, decl));
        }
        return count ;
    }
}
