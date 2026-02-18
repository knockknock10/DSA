class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = 5;   // dummy value to indicate no previous bit yet
        
        while(n > 0){
            int bit = n % 2;   // get last bit
            n /= 2;            // remove last bit
            
            if(prev == 5){
                prev = bit;    // first bit, just store it
            }else{
                if(bit == prev) return false; // same as previous → not alternating
                prev = bit;
            }
        }
        return true;
    }
}

