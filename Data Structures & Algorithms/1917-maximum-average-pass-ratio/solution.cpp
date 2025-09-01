using info = tuple<double, int, int>;
info A[100000];
class Solution {
public:
    static double maxAverageRatio(vector<vector<int>>& classes, int k) {
        const int n = classes.size();
        double sum = 0.0;
        int i = 0;
        for (auto& pq : classes) {
            int p = pq[0], q = pq[1];
            sum += (double)p/q;
            double inc=(double)(q - p) / (q * (q + 1.0));
            A[i++]={inc, p, q};
        }
        
        make_heap(A, A+n);
        
        for (int i = 0; i < k; i++) {
            pop_heap(A, A+n);
            auto [r, p, q] = A[n-1];
            if (r==0) break;// early stop
            
            // Add the current inc to the sum
            sum += r;
            double r2= (double)(q - p) / ((q +1.0)* (q + 2.0));
            A[n-1]={ r2, p+1, q+1};
            push_heap(A, A+n);
        }
        
        return sum / n;
    }
};

auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
