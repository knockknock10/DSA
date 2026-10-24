// class Solution {

//     public int minOperations(int[] nums) {
//         final int n = nums.length;
//         if (n == 1) {
//             return 0;
//         }

//         int start = 0;
//         while (nums[start] != 0) {
//             start++;
//         }

//         boolean asc = true;
//         boolean desc = true;

//         for (int i = 1; i < n; i++) {
//             final int value = nums[(start + i) % n];

//             if (value != i) {
//                 asc = false;
//             }
//             if (value != n - i) {
//                 desc = false;
//             }

//             if (!asc && !desc) {
//                 return -1;
//             }
//         }

//         if (asc) {
//             return Math.min(start, n - start + 2);
//         }

//         return Math.min(n - start, start + 2);
//     }
// }
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc_count = 0;
        int dsc_count = 0;  // was "dsc_coutn"
        for (int i = 1; i < n; i++) {
            asc_count += (nums[i] == (nums[i-1] + 1) % n) ? 1 : 0;
            dsc_count += (nums[i] == (nums[i-1] - 1 + n) % n) ? 1 : 0;
        }

        if (asc_count == n - 1) {
            int zero = (n - nums[0]) % n;
            return Math.min(zero, n - zero + 2);
        }
        if (dsc_count == n - 1) {
            int zero = nums[0];
            return Math.min(zero + 2, n - zero);
        }
        return -1;
    }
}   
