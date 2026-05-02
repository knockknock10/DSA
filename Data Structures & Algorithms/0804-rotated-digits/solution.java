class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1;i<=N;i++) if (getCount(i) > 0) count++;
        return count;
    }
    
    public int getCount(int num){
        int count  = 0;
        while (num > 0){
                int r = num % 10;
                if (r == 3 || r == 4 || r == 7) return 0;
                if (r == 2 || r == 5 || r == 6 || r == 9) count++;
                num = num / 10;
        }
        return count;
    }
}
