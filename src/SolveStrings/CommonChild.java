/**
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String str1, String str2) {
        int size1 =str1.length();
        int size2=str2.length();
        int lengthArray[][] = new int[size1+1][size2+1];
        for(int i =0; i<size1+1; i++){
            for(int j=0; j<size2+1; j++){
                if(i==0 || j==0){
                    lengthArray[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    lengthArray[i][j]=lengthArray[i-1][j-1]+1;
                }
                else{
                    lengthArray[i][j]=Math.max(lengthArray[i-1][j],                                 lengthArray[i][j-1]);
                }
            }
        }
        return lengthArray[size1][size2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
