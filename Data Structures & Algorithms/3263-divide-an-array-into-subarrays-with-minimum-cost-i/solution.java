class Solution {
    public int minimumCost(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                min = Math.min(min,nums[0]+nums[i]+nums[j]);
            }
        }
        return min;
    }
}
