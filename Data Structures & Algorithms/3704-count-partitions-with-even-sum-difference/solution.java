class Solution {
    public int countPartitions(int[] nums) {
        int totas = 0;
        int count = 0;
        int lefts = 0;
        for(int x:nums){
            totas+=x;
        }
        for(int i=0;i<nums.length-1;i++){
            lefts+=nums[i];
            int rights = totas-lefts;
            if((lefts %2)==(rights%2)){
                count++;
            }
        }return count;
    }
}
