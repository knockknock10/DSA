from typing import List

class Solution:
    def dfs(self, node: int, color: int, graph: List[List[int]],
            component: List[int], bipartite: List[int]) -> None:
        bipartite[color] += 1
        component[node] = color
        for neighbor in graph[node]:
            if component[neighbor] == -1:
                self.dfs(neighbor, 1 - color, graph, component, bipartite)

    def build_graph(self, edges: List[List[int]], n: int) -> List[List[int]]:
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        return graph

    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]]) -> List[int]:
        n1, n2 = len(edges1) + 1, len(edges2) + 1


        graph1 = self.build_graph(edges1, n1)
        graph2 = self.build_graph(edges2, n2)

 
        component1 = [-1] * n1
        bipartite1 = [0, 0]
        self.dfs(0, 0, graph1, component1, bipartite1)


        ans = [bipartite1[component1[i]] for i in range(n1)]


        component2 = [-1] * n2
        bipartite2 = [0, 0]
        self.dfs(0, 0, graph2, component2, bipartite2)

        max_bipartite2 = max(bipartite2)
        return [val + max_bipartite2 for val in ans]
