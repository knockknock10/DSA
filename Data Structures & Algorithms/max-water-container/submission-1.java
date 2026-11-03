class Solution {
    public int maxArea(int[] ht) {
        int ans = 0;
        // for(int i=0;i<ht.length;i++){
        //     for(int j=i+1;j<ht.length;j++){
        //         int h = Math.min(ht[i],ht[j]);
        //         int w = j-i;
        //         int wat = h*w;
        //         ans = Math.max(wat,ans);
        //     }
        // }
        int left = 0,right = ht.length-1;
        while(left<right){
            int h = Math.min(ht[left],ht[right]);
            int w = right-left;
            ans = Math.max(ans,h*w);
            if(ht[left]<ht[right]) left++; //move pointer with short ht
            else right--;
        }
        return ans;
    }
}
