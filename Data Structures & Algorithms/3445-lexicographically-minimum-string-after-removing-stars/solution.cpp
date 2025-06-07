class Solution {
public:
    string clearStars(string s) {
        int n = s.size();
        priority_queue<char, vector<char>, greater<char>> pq;  // Min-heap
        unordered_map<char, vector<int>> m;  // Stores indices of each character
        vector<bool> v(n, true);  // Marks whether each char in s should be kept

        for (int i = 0; i < n; i++) {
            if (s[i] == '*') {
                char temp = pq.top();  // Get smallest char so far
                pq.pop();
                int last = m[temp].back();  // Get last occurrence index
                m[temp].pop_back();
                v[i] = false;       // Remove '*'
                v[last] = false;    // Remove corresponding smallest char
            } else {
                pq.push(s[i]);
                m[s[i]].push_back(i);
            }
        }

        string result = "";
        for (int i = 0; i < n; i++) {
            if (v[i]) result += s[i];
        }
        return result;
    }
};
