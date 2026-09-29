class Solution {
    public int matrixSum(int[][] nums) {
        int sum  = 0;
        for(int[] i:nums){
            Arrays.sort(i);
        }
        for(int i=nums[0].length-1;i>=0;i--){
            int max = 0;
            for(int j=0;j<nums.length;j++){
                max = Math.max(max,nums[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}
