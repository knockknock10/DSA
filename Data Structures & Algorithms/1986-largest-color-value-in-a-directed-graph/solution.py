from array import array

class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
#---------------------------------------------------------------------
        # Solution 1: BFS accumulating color frequencies #---------------------------------------------------------------------
        n = len(colors)
        adj = [[] for _ in range(n)]
        indeg = [0] * n
        for u, v in edges:
            adj[u].append(v)
            indeg[v] += 1

        dp = [[0] * 26 for _ in range(n)]
        q = deque()
        for i in range(n):
            if indeg[i] == 0:
                q.append(i)
                dp[i][ord(colors[i]) - 97] = 1

        visited, res = 0, 0
        while q:
            u = q.popleft()
            visited += 1
            res = max(res, max(dp[u]))
            for v in adj[u]:
                ci = ord(colors[v]) - 97
                for c in range(26):
                    val = dp[u][c] + (1 if c == ci else 0)
                    if val > dp[v][c]:
                        dp[v][c] = val
                indeg[v] -= 1
                if indeg[v] == 0:
                    q.append(v)
        return res if visited == n else -1

#---------------------------------------------------------------------
        # Solution 2: Memory efficient breath first DP
#---------------------------------------------------------------------
        n = len(colors)
        # Map each node’s color to 0–25 once up front
        col = [ord(c) - 97 for c in colors]
        adj = [[] for _ in range(n)] # build graph + indegree
        indeg = [0] * n
        for u, v in edges:
            adj[u].append(v)
            indeg[v] += 1
        
        dp = [array('I', [0])*26 for _ in range(n)]
        q = deque()
        for i in range(n):  # Initialize sources
            if indeg[i] == 0:
                q.append(i)
                dp[i][col[i]] = 1
        
        seen, res = 0, 0
        while q:
            u = q.popleft()
            seen += 1
            au = max(dp[u])  # Update global answer from dp[u]
            if au > res: 
                res = au
            
            base = dp[u]
            for v in adj[u]:
                row_v = dp[v]
                cv = col[v]
                for c in range(26): # Propagate all 26 colors
                    val = base[c] + (1 if c == cv else 0)
                    if val > row_v[c]:
                        row_v[c] = val
                indeg[v] -= 1
                if indeg[v] == 0:
                    q.append(v)
            dp[u] = None
        
        return res if seen == n else -1
