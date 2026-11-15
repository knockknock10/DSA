class Solution {
    public int numOfSubarrays(int[] arr) {
        final int mod = 1_000_000_007;
        int even = 1;
        int odd = 0;
        int res = 0;
        int pres = 0;
        for(int nums:arr){
            pres+=nums;
            if(pres%2!=0){
                res = (res+even)%mod;
                odd++;
            }else{
                res = (res+odd)%mod;
                even++;
            }
        }return res;
    }
}
