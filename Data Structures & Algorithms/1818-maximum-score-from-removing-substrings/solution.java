class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalPoints = 0;
        String highPriorityPair = (x > y) ? "ab" : "ba";
        String lowPriorityPair = (x > y) ? "ba" : "ab";
        int highPriorityScore = Math.max(x, y);
        int lowPriorityScore = Math.min(x, y);

        // First pass for the higher score
        Result afterFirstPass = solve(s, highPriorityPair, highPriorityScore);
        totalPoints += afterFirstPass.points;

        // Second pass for the lower score on the remaining string
        Result afterSecondPass = solve(afterFirstPass.remainingString, lowPriorityPair, lowPriorityScore);
        totalPoints += afterSecondPass.points;

        return totalPoints;
    }

    private Result solve(String text, String pattern, int score) {
        StringBuilder stack = new StringBuilder();
        int points = 0;
        char p1 = pattern.charAt(0);
        char p2 = pattern.charAt(1);

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            int stackLen = stack.length();
            if (stackLen > 0 && stack.charAt(stackLen - 1) == p1 && currentChar == p2) {
                stack.deleteCharAt(stackLen - 1);
                points += score;
            } else {
                stack.append(currentChar);
            }
        }
        return new Result(points, stack.toString());
    }

    // Helper class to return multiple values from the solve function
    private static class Result {
        int points;
        String remainingString;

        Result(int points, String remainingString) {
            this.points = points;
            this.remainingString = remainingString;
        }
    }
}
