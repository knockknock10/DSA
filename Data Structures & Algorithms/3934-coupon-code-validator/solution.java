import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Business line priority
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<Pair> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && priority.containsKey(businessLine[i]) && isValidCode(code[i])) {
                valid.add(new Pair(priority.get(businessLine[i]), code[i]));
            }
        }

        // Sort by business priority, then by code
        Collections.sort(valid, (a, b) -> {
            if (a.priority != b.priority)
                return a.priority - b.priority;
            return a.code.compareTo(b.code);
        });

        List<String> result = new ArrayList<>();
        for (Pair p : valid) {
            result.add(p.code);
        }

        return result;
    }

    private boolean isValidCode(String s) {
        if (s.length() == 0) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_')
                return false;
        }
        return true;
    }

    // Helper class to store (priority, code)
    static class Pair {
        int priority;
        String code;

        Pair(int priority, String code) {
            this.priority = priority;
            this.code = code;
        }
    }
}
