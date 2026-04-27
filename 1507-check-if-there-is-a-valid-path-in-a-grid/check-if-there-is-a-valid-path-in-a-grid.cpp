#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();

        
        map<int, vector<pair<int,int>>> dirs = {
            {1, {{0,-1}, {0,1}}},
            {2, {{-1,0}, {1,0}}},
            {3, {{0,-1}, {1,0}}},
            {4, {{0,1}, {1,0}}},
            {5, {{0,-1}, {-1,0}}},
            {6, {{0,1}, {-1,0}}}
        };

        queue<pair<int,int>> q;
        vector<vector<bool>> vis(m, vector<bool>(n, false));

        q.push({0,0});
        vis[0][0] = true;

        while(!q.empty()) {
            auto [x, y] = q.front();
            q.pop();

            if(x == m-1 && y == n-1) return true;

            for(auto [dx, dy] : dirs[grid[x][y]]) {
                int nx = x + dx;
                int ny = y + dy;

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !vis[nx][ny]) {

                    
                    for(auto [rdx, rdy] : dirs[grid[nx][ny]]) {
                        if(nx + rdx == x && ny + rdy == y) {
                            vis[nx][ny] = true;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }

        return false;
    }
};