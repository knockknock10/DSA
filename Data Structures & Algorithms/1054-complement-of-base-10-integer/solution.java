class Solution {
    public int bitwiseComplement(int n) {
         int mask = n | 1; // edge case n == 0
        for (int i = 0; i <= 4; i++)
            mask |= mask >> (1 << i);
        return n ^ mask; // alternative
    }
}
