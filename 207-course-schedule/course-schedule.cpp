class Solution {
public:
    bool dfs(int node, vector<vector<int>>& adj, vector<int>& vis) {
        // vis[node] = 1 → visiting (in recursion stack)
        // vis[node] = 2 → visited

        vis[node] = 1;

        for (auto neigh : adj[node]) {
            if (vis[neigh] == 0) {
                if (dfs(neigh, adj, vis)) return true;
            }
            else if (vis[neigh] == 1) {
                return true; // cycle
            }
        }

        vis[node] = 2;
        return false;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);

        for (auto &p : prerequisites) {
            adj[p[1]].push_back(p[0]);
        }

        vector<int> vis(numCourses, 0);

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis)) return false;
            }
        }

        return true;
    }
};