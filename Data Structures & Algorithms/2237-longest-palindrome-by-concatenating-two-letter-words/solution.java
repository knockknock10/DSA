import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int result = 0;
        boolean hasCenter = false;

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (String word : count.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)) {
                if (count.containsKey(reversed)) {
                    int pairCount = Math.min(count.get(word), count.get(reversed));
                    result += pairCount * 4;
                    count.put(word, count.get(word) - pairCount);
                    count.put(reversed, count.get(reversed) - pairCount);
                }
            } else {
                int pairs = count.get(word) / 2;
                result += pairs * 4;
                count.put(word, count.get(word) - pairs * 2);
            }
        }

        for (String word : count.keySet()) {
            if (word.charAt(0) == word.charAt(1) && count.get(word) > 0) {
                result += 2;
                break;
            }
        }

        return result;
    }
}

