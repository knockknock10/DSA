class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);
        int n = arr.length;
        int sum = 0;
        int minl = n;
        int ans=n+1;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(m.containsKey(sum-target)){
                int j = m.get(sum-target);
                int len = i-j;
                ans = Math.min(ans,len+(j==-1 ? n:arr[j]));
                minl = Math.min(minl,len);

            }
            arr[i] = minl;
            m.put(sum,i);
        }
        return ans==n+1?-1:ans;
    }
}
