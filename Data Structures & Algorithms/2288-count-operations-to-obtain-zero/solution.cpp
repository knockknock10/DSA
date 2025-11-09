class Solution {
public:
    int countOperations(int x, int y) {
        int cnt=0, r;
        for( ; y>0; x=y, y=r){
            cnt+=x/y; 
            r=x%y;  
        }
        return cnt;
    }
};
