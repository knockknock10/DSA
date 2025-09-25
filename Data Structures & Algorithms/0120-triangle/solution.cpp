class Solution {
public:
    int minimumTotal(vector<vector<int>>& t) {
        const int n=t.size();
        for(int i=1; i<n; i++){
            t[i][0]+=t[i-1][0];
            t[i][i]+=t[i-1][i-1];
            for(int j=1; j<i; j++){
                t[i][j]+=min(t[i-1][j], t[i-1][j-1]);
            }
        }
        return *min_element(t[n-1].begin(), t[n-1].end());
    }
};
