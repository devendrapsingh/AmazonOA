package InterviewProblems.AmazonInterviewProblems.AmazonOA;

public class AmazonGoStore_IslandProblem {


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int row = grid.length;

        if (row == 0) return 0;

        int col = grid[0].length;


        int count = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(i, j, grid, row, col);
                    count++;
                }
            }
        }
        return count;

    }

    static void dfs(int i, int j, char[][] grid, int row, int col) {


        if (i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        dfs(i + 1, j, grid, row, col);
        dfs(i - 1, j, grid, row, col);
        dfs(i, j + 1, grid, row, col);
        dfs(i, j - 1, grid, row, col);

    }

}
