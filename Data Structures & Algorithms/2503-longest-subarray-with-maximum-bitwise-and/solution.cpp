class Solution {
public:
    static int longestSubarray(vector<int>& nums) {
        const int n=nums.size();
        int maxLen=0, xMax=0;
        for(int r=0, l=0; r<n; r++){
            while(r<n && nums[r]==xMax){
                r++;
            }
            if (r==n || nums[r]<xMax) {
                maxLen=max(maxLen, r-l);
                l=r+1;
            }
            else {
                xMax=nums[r];
                maxLen=1;
                l=r;
            }
        }
        return maxLen;
    }
};


auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
