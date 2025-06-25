class Solution 
{
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) 
    {
        // Step 1: Swap to ensure nums1 is the shorter array (optimization)
        if (nums1.length > nums2.length) 
        {
            return kthSmallestProduct(nums2, nums1, k);
        }

        // Step 2: Set binary search bounds for product space
        long lo = -1_0000_0000_00L;
        long hi = 1_0000_0000_00L;

        // Step 3: Binary search for smallest number with at least k products <= it
        while (lo < hi) 
        {
            long mid = lo + (hi - lo) / 2;
            long cnt = countLE(mid, nums1, nums2); // count of products <= mid

            if (cnt < k) 
            {
                lo = mid + 1; // need bigger product
            } 
            else 
            {
                hi = mid; // try smaller (mid might be answer)
            }
        }

        return lo; // kth smallest product
    }

    // Step 4: Count number of products <= x
    public long countLE(long x, int[] A, int[] B) 
    {
        long count = 0;
        int n = B.length;

        if (x >= 0) 
        {
            // Case 1: x is positive
            int jPos = n - 1;
            int jNeg = n - 1;

            for (int a : A) 
            {
                if (a > 0) 
                {
                    while (jPos >= 0 && a * 1L * B[jPos] > x)
                    {
                        jPos--;
                    }
                     
                    count += jPos + 1;
                } 
                else if (a == 0) 
                {
                    count += n; // All zero products <= x (x >= 0)
                } 
                else 
                {
                    while (jNeg >= 0 && a * 1L * B[jNeg] <= x)
                    {
                        jNeg--;
                    }

                    count += n - 1 - jNeg;
                }
            }
        } else 
        {
            // Case 2: x is negative
            int jPos = 0;
            int jNeg = 0;

            for (int a : A) 
            {
                if (a > 0) 
                {
                    while (jPos < n && a * 1L * B[jPos] <= x)
                    {
                        jPos++;
                    }

                    count += jPos;
                } 
                else if (a == 0) 
                {
                    // All zero products > negative x
                } 
                else 
                {
                    while (jNeg < n && a * 1L * B[jNeg] > x)
                    {
                        jNeg++;
                    }

                    count += n - jNeg;
                }
            }
        }

        return count;
    }
}
