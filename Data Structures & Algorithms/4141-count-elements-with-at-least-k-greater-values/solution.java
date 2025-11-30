class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int a = nums.length;
        if(k==0){
            return a;
        }
        if(k>=a){return 0;}
        int c = nums[a-k];
        
        int cout = 0;
        for(int z:nums){
            if(z<c){
                cout++;
            }
        }
        return cout;
    }
}
