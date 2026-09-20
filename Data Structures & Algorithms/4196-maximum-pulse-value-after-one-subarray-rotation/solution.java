class Solution {
    public long maxValue(int[] nums) {
       int[] rv = nums;
        long f=0,be = Long.MIN_VALUE,bo=Long.MIN_VALUE,bd = 0;
        for(int r= 0;r<nums.length;r++){
            f+=(r%2==0?nums[r]:-nums[r]);
            long mx = (r%2==0)?be:bo;
            if(mx!=Long.MIN_VALUE) bd= Math.max(bd,mx-2*f);
            long v = 2*f;
            if(r%2==0){
                be = Math.max(be,v);
                bo = Math.max(bo,v-2*nums[r]);
                
            }else{
                bo = Math.max(bo,v);
                be = Math.max(be,v+2*nums[r]);
                
            }
            
        }
        return f+bd;
    }
}
