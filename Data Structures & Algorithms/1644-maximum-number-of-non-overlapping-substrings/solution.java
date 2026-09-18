class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Store first and last occurrence of every character.
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Build valid intervals.
        for (int i = 0; i < 26; i++) {
            if (last[i] == -1)
                continue;

            int l = first[i];
            int r = last[i];
            boolean valid = true;

            for (int j = l; j <= r; j++) {
                int x = s.charAt(j) - 'a';

                if (first[x] < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, last[x]);
            }

            if (valid)
                intervals.add(new int[]{l, r});
        }

        // Sort by ending position.
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        // Greedily take the earliest-ending non-overlapping interval.
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];

            if (l > prevEnd) {
                ans.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return ans;
    }
}
