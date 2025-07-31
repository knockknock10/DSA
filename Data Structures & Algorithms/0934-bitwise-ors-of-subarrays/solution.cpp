class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        vector<int> ans;
        const int n=arr.size();
        for(int i=0; i<n; i++){
            const int x=arr[i];
            int skip=0, take=x;
            ans.push_back(take);
            for(int j=i-1; j>=0; j--){
                skip|=arr[j];
                take=skip|x;
                if (skip==take) break;
                ans.push_back(take);
            }
        }   
        sort(ans.begin(), ans.end());
        return unique(ans.begin(), ans.end())-ans.begin();
    }
};
