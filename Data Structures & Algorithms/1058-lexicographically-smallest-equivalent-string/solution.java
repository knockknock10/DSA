class Solution 
{
    int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) 
    {
        // Step 1: Initialize parent array
        for (int i = 0; i < 26; i++) 
        {
            parent[i] = i;
        }

        // Step 4: Build equivalence groups
        for (int i = 0; i < s1.length(); i++) 
        {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Step 5: Transform baseStr
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) 
        {
            result.append((char)(find(ch - 'a') + 'a'));
        }

        return result.toString();
    }

    // Step 2: Find with path compression
    private int find(int x) 
    {
        if (parent[x] != x) 
        {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }

    // Step 3: Union with lexicographical priority
    private void union(int x, int y) 
    {
        int px = find(x), py = find(y);
        if (px == py)
        {
            return;
        }

        if (px < py) 
        {
            parent[py] = px;
        } 
        else 
        {
            parent[px] = py;
        }
    }
}
