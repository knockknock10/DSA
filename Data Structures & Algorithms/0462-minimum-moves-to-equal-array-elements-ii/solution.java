class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = nums[n/2];
        long ans = 0;
        for(int i=0;i<n;i++){
            ans+=Math.abs((long) nums[i]-m);

        }
        return (int) ans;
    }
}
