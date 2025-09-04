class Solution {
public:
    int findClosest(int x, int y, int z) {
         return abs(x-z)==abs(y-z)?0:2-(abs(x-z)<abs(y-z));
    }
};
