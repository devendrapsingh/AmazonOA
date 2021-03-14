package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxOfMinAltitudes {

    public static void main(String[] args) {
      //  int [][] grid = {{1, 2, 3},{4, 5, 1}};
        int [][] grid= {{5,1}};

        System.out.println(solve(grid));
    }
    static int solve(int [][] grid){

        Queue<int[]> q= new LinkedList<>();

        q.add(new int[]{0,0,Integer.MAX_VALUE});

        List<Integer> list = new ArrayList<>();
        int row = grid.length, col = grid[0].length;

        while(!q.isEmpty()){

            int [] p = q.poll();

            int x = p[0],y=p[1], val = p[2];

            if((x+1==row-1 && y==col-1) || (x==row-1 && y+1==col-1)){
                list.add(val);
                continue;
            }

            if(p[0]+1<row){
                q.add(new int[]{x+1,y,Math.min(grid[x+1][y],val)});
            }
            if(y+1<col){
                q.add(new int[]{x,y+1,Math.min(grid[x][y+1],val)});
            }

        }
        //System.out.println(list.toString());
        // mind max in min values
        int ans = 0;
        for(int i: list){
            ans = Math.max(ans,i);
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}
