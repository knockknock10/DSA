class Solution {
    private long flipped;
    private int[] left;
    private int[] right;
    private TreeSet<long[]> pairSum;

    public int minimumPairRemoval(int[] nums) {
        int N = nums.length;
        if (N < 2) return 0;

        long[] array = new long[N];
        for (int i = 0; i < N; i++)
            array[i] = nums[i];

        flipped = 0;
        left = new int[N];
        right = new int[N];

        pairSum = new TreeSet<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        for (int i = 0; i < N; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (array[i] > array[i + 1]) flipped++;
            pairSum.add(new long[] { array[i] + array[i + 1], i });
        }

        int op = 0;
        while (flipped > 0 && !pairSum.isEmpty()) {
            long[] first = pairSum.pollFirst();
            int i = (int) first[1];

            int j = right[i];
            int h = left[i];
            int k = right[j];

            remove(h, N, array);
            if (array[i] > array[j])
                flipped--;
            remove(j, N, array);

            array[i] += array[j];

            op++;
            right[i] = k;
            if (k < N) {
                left[k] = i;
            }

            add(h, N, array);
            add(i, N, array);
        }

        return op;
    }

    private void add(int i, int N, long[] array) {
        if (i >= 0 && i < N) {
            int j = right[i];
            if (j < N) {
                pairSum.add(new long[] { array[i] + array[j], i });
                if (array[i] > array[j])
                    flipped++;
            }
        }
    }

    private void remove(int i, int N, long[] array) {
        if (i >= 0 && i < N) {
            int j = right[i];
            if (j < N) {
                long[] target = new long[] { array[i] + array[j], i };
                if (pairSum.contains(target)) {
                    if (array[i] > array[j])
                        flipped--;
                    pairSum.remove(target);
                }
            }
        }
    }

}
