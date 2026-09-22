class Solution {
    private static class Info {
        int[] ways;
        int whole;

        Info(int k) {
            ways = new int[k];
            whole = 1;
        }
    }

    private static class SegmentTree {
        int size;
        int mod;
        Info[] tree;

        SegmentTree(int[] nums, int k) {
            mod = k;
            size = 1;

            while (size < nums.length) {
                size <<= 1;
            }

            tree = new Info[size * 2];

            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Info(k);
            }

            for (int i = 0; i < nums.length; i++) {
                int rem = nums[i] % k;

                tree[size + i].ways[rem] = 1;
                tree[size + i].whole = rem;
            }

            for (int i = size - 1; i > 0; i--) {
                tree[i] = combine(tree[i << 1], tree[i << 1 | 1]);
            }
        }

        private Info combine(Info left, Info right) {
            Info merged = new Info(mod);

            for (int r = 0; r < mod; r++) {
                merged.ways[r] = left.ways[r];
            }

            for (int r = 0; r < mod; r++) {
                if (right.ways[r] == 0) {
                    continue;
                }

                int newRem = (left.whole * r) % mod;
                merged.ways[newRem] += right.ways[r];
            }

            merged.whole = (left.whole * right.whole) % mod;

            return merged;
        }

        void update(int index, int value) {
            int pos = size + index;
            int rem = value % mod;

            Arrays.fill(tree[pos].ways, 0);
            tree[pos].ways[rem] = 1;
            tree[pos].whole = rem;

            pos >>= 1;

            while (pos > 0) {
                tree[pos] = combine(
                    tree[pos << 1],
                    tree[pos << 1 | 1]
                );

                pos >>= 1;
            }
        }

        Info query(int left, int right) {
            Info leftPart = new Info(mod);
            Info rightPart = new Info(mod);

            left += size;
            right += size;

            while (left < right) {
                if ((left & 1) != 0) {
                    leftPart = combine(leftPart, tree[left]);
                    left++;
                }

                if ((right & 1) != 0) {
                    right--;
                    rightPart = combine(tree[right], rightPart);
                }

                left >>= 1;
                right >>= 1;
            }

            return combine(leftPart, rightPart);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums, k);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            tree.update(index, value);

            Info result = tree.query(start, nums.length);
            answer[i] = result.ways[x];
        }

        return answer;
    }
}
