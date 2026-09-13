class Solution {
    public long shadowPairs(int[] nums) {
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        int n = nums.length;
        st.add(nums[0]);
        for(int i=1;i<=n;i++){
            if(i<n && st.peek()<=nums[i]){
                st.add(nums[i]);
            }else{
                long c= 1;
                while(st.size()>0 && (i==n || st.peek()>nums[i])){
                    int prev = st.pop();
                    if(st.size()>0 && prev!=st.peek()){
                        ans+=(st.size()*c);
                        c=1;
                    }
                    else if (st.size()>0 && prev==st.peek()) c++;

                }
                if(i<n) st.add(nums[i]);
            }
        }
        return ans;
    }
}
