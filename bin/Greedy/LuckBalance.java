import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/luck-balance/problem
 */
class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int[] priorityValues = new int[contests.length];
        int luckValue = 0;
        for(int i=0; i<contests.length; i++){
            if(contests[i][1]==1){
                priorityValues[i]=contests[i][0];
            }
            else{
                luckValue+=contests[i][0];
            }
        }
        Arrays.sort(priorityValues);
        for(int i=0; i<contests.length-k; i++){
            luckValue-=priorityValues[i];
        }
        for(int i=contests.length-k; i<priorityValues.length; i++){
            luckValue+=priorityValues[i];
        }
        
        return luckValue;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
