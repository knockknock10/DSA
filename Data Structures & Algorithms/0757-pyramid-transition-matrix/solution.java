class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        List<Character>[][] map = new List[6][6];
        Map<String, Boolean> memo = new HashMap<>();
        
        for (String al : allowed) {
            int a = al.charAt(0) - 'A';
            int b = al.charAt(1) - 'A';
            if (map[a][b] == null) map[a][b] = new ArrayList<>();
            map[a][b].add(al.charAt(2));
        }
        
        return dfs(bottom.toCharArray(), map, memo);
    }
    
    private boolean dfs(char[] row, List<Character>[][] map, Map<String, Boolean> memo) {
        int n = row.length;
        if (n == 1) return true;
        
        String key = new String(row);
        if (memo.containsKey(key)) return memo.get(key);
        
        List<char[]> nextRows = new ArrayList<>();
        getNextRows(row, map, 0, new char[n-1], nextRows);
        
        for (char[] next : nextRows) {
            if (dfs(next, map, memo)) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }
    
    private void getNextRows(char[] row, List<Character>[][] map, int idx, 
                            char[] current, List<char[]> result) {
        if (idx == row.length - 1) {
            result.add(current.clone());
            return;
        }
        
        int a = row[idx] - 'A';
        int b = row[idx + 1] - 'A';
        
        if (map[a][b] == null) return;
        
        for (char c : map[a][b]) {
            current[idx] = c;
            getNextRows(row, map, idx + 1, current, result);
        }
    }
}
