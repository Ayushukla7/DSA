class Solution {

    class State {
        int row;
        int col;
        int health;

        State(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], -1);
        }

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> b.health - a.health);

        pq.offer(new State(0, 0, startHealth));
        best[0][0] = startHealth;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            if (cur.row == m - 1 && cur.col == n - 1)
                return true;

            for (int[] d : dir) {

                int nr = cur.row + d[0];
                int nc = cur.col + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newHealth = cur.health - grid.get(nr).get(nc);

                if (newHealth <= 0)
                    continue;

                if (newHealth > best[nr][nc]) {

                    best[nr][nc] = newHealth;

                    pq.offer(new State(nr, nc, newHealth));
                }
            }
        }

        return false;
    }
}