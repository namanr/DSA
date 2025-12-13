// LeetCode 695: Max Area of Island
// Given a grid of 0s and 1s, return the area of the largest island.
// An island is a group of adjacent 1s connected horizontally or vertically.

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int sr, int sc) {
        int m = grid.length, n = grid[0].length;
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{sr, sc});
        grid[sr][sc] = 0;

        int area = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    area++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return area;
    }
}
