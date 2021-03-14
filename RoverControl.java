package InterviewProblems.AmazonInterviewProblems.AmazonOA;

public class RoverControl {

    public static void main(String[] args) {

        //0 1 2 3 4
        //5 6

    String [] s ={"RIGHT", "UP", "DOWN", "LEFT", "DOWN","DOWN","DOWN"};
    int n = 4;
        System.out.println(solve(s,n));
        System.out.println(solve1(s,n));

    }
    static int solve(String [] command , int n){

        int dir = 0;

        for(String s: command){

            if(s.equals("UP")){
                if(dir-n>=0){
                    dir=dir-n;
                }

            }else if(s.equals("DOWN")){
                if(dir+n<=(n*n-1)){
                    dir=dir+n;
                }

            }else if(s.equals("LEFT")){

                if(dir%n!=0){
                    dir=dir-1;
                }

            }else if(s.equals("RIGHT")){

                if((dir+1)%n!=0)
                    dir=dir+1;
            }
        }
    return dir;

    }
    static int solve1(String [] command, int n){

        int row = 0;
        int col = 0;

        /*
            n=4

            0   1  2 3
            4   5  6 7
            8   9 10 11
            12 13 14 15

        pos = (row*size)+col

        //"RIGHT", "UP", "DOWN", "LEFT", "DOWN","DOWN","DOWN"
        //output - 12
         */

        for(String s: command){

            if(s.equals("UP")){
                if(row>0){
                    row = row-1;
                }
            }else if(s.equals("DOWN")){
                if(row<n-1){
                    row = row+1;
                }
            }else if(s.equals("LEFT")){
                if(col>0){
                    col = col-1;
                }
            }else if(s.equals("RIGHT")){
                if(col<n-1){
                    col = col+1;
                }
            }

        }

        return (row*n)+col;
    }
}
