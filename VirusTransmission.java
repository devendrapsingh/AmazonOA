package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.LinkedList;
import java.util.Queue;

public class VirusTransmission {


    public static void main(String[] args) {

        Integer [][] grid={{0,2,null,2,0},{2,1,2,1,2},{null,1,2,1,null},{null,null,2,null,null}};
        //Integer [][] grid ={{1,null},{0,1}};
        System.out.println(solve(grid));


    }
    static int solve(Integer [][] grid){

        if(grid.length==0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int [] dirs = {0,1,0,-1,0};

        Queue<int[]> q = new LinkedList<>();

        // check whether virus is present or not
        // if so , insert them into queue to perform
        // multi node bfs operation
        int count = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=null && grid[i][j]==0)
                    q.add(new int[]{i,j,0});   // 0 to handle cases where 2 is present
                else if(grid[i][j]!=null)
                    count++;  // to count how many cells need to infect
            }
        }


        if(count==0) return 0; // to handle case when no cells need to infected
        if(q.size()==0) return -1; // if no virus present, then we can not infect other cells

        int level = 0;

        while(!q.isEmpty()){
            level++;
            int n = q.size();

            for(int i=0;i<n;i++){

                int [] p = q.poll();

                if(p[2]==1){
                    q.add(new int[]{p[0],p[1],--p[2]});
                    continue;
                }

                for(int j=0;j<dirs.length-1;j++){

                    int x = p[0]+dirs[j];
                    int y = p[1]+dirs[j+1];

                    if(x<0 || x>=row || y<0 || y>=col || grid[x][y]==null || grid[x][y]==0){
                        continue;
                    }
                    count--;
                    if( grid[x][y]==2) {
                        grid[x][y] = null;
                        q.add(new int[]{x, y, 1});  // to handle when cell contains 2
                    }else if(grid[x][y]==1){
                        grid[x][y]=null;
                        q.add(new int[]{x,y,0});
                    }
                }
            }
        }
        return count==0 ? level-1 : -1;

    }
}
