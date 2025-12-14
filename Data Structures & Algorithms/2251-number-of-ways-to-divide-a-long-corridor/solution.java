class Solution {
    // Store 1000000007 in a variable for convenience
    private static final int MOD = 1_000_000_007;

    // Count the number of ways to divide from "index" to the last index
    // with "seats" number of "S" in the current section
    private int count(int index, int seats, String corridor, Map<Pair<Integer, Integer>, Integer> cache) {
        // If we have reached the end of the corridor, then
        // the current section is valid only if "seats" is 2
        if (index == corridor.length()) {
            return seats == 2 ? 1 : 0;
        }

        // If we have already computed the result of this sub-problem,
        // then return the cached result
        if (cache.containsKey(new Pair<>(index, seats))) {
            return cache.get(new Pair<>(index, seats));
        }

        // Result of the sub-problem
        int result = 0;

        // If the current section has exactly 2 "S"
        if (seats == 2) {
            // If the current element is "S", then we have to close the
            // section and start a new section from this index. Next index
            // will have one "S" in the current section
            if (corridor.charAt(index) == 'S') {
                result = count(index + 1, 1, corridor, cache);
            } else {
                // If the current element is "P", then we have two options
                // 1. Close the section and start a new section from this index
                // 2. Keep growing the section
                result = (count(index + 1, 0, corridor, cache) + count(index + 1, 2, corridor, cache)) % MOD;  
            }
        } else {
            // Keep growing the section. Increment "seats" if present
            // element is "S"
            if (corridor.charAt(index) == 'S') {
                result = count(index + 1, seats + 1, corridor, cache);
            } else {
                result = count(index + 1, seats, corridor, cache);
            }
        }

        // Memoize the result, and return it
        cache.put(new Pair<>(index, seats), result);
        return result;
    }


    public int numberOfWays(String corridor) {
        // Cache the result of each sub-problem
        Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

        // Call the count function
        return count(0, 0, corridor, cache);
    }
}
