// LeetCode 200: Number of Islands
// Given a 2D grid consisting of '1's (land) and '0's (water),
// return the number of islands. An island is surrounded by water
// and formed by connecting adjacent lands horizontally or vertically.

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int sr, int sc) {
        int m = grid.length, n = grid[0].length;
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{sr, sc});
        grid[sr][sc] = '0';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
