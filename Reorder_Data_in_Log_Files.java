package InterviewProblems.AmazonInterviewProblems.AmazonOA;

import java.util.Arrays;

public class Reorder_Data_in_Log_Files {


    public static void main(String[] args) {

        String [] log = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(log)));
    }

    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,(a,b)->{

            int firstIndex  = a.indexOf(' ')+1;
            int secondIndex = b.indexOf(' ')+1;

            if(a.charAt(firstIndex)<='9'){
                if(b.charAt(secondIndex)<='9')
                    return 0;
                return 1;
            }

            if(b.charAt(secondIndex)<='9')
                return -1;

            int dis = a.substring(firstIndex).compareTo(b.substring(secondIndex));

            if(dis==0){
                return a.substring(0,firstIndex).compareTo(b.substring(0,secondIndex));
            }
            return dis;

        });

        return logs;
    }
}
