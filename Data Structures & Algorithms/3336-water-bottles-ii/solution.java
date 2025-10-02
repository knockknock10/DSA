class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        int emp = numBottles;
        while (emp >= numExchange) {
            emp -= numExchange;
            res++;
            emp++;
            numExchange++;
        }
        return res;
    }
}
