class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        // ans.add(1);
        // for(int i=1;i<=rowIndex;i++){
        //     ans.add(1);
        //     for(int j=i-1;j>0;j--){
        //         int sum = ans.get(j)+ans.get(j-1);
        //         ans.set(j,sum);
        //     }
        // }
        long cur = 1;
        ans.add((int)cur);
        for(int i=1;i<=rowIndex;i++){
            cur = cur*(rowIndex-i+1)/i;
            ans.add((int)cur);
        }
        return ans;
    }
}
