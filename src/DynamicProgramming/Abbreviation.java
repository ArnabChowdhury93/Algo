/**
 * https://www.hackerrank.com/challenges/abbr/problem
 */
public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        boolean[][] abbr = new boolean[a.length()+1][b.length()+1];
      
        // tabulation from start of string
        for (int k = 0; k <= a.length(); k++) {
            for (int l = 0; l <= b.length(); l++) {
               if(k<l){
                   abbr[k][l]=false;
               }
               else if(k==0 && l==0){
                   abbr[k][l]=true;
               }
               else if(l==0){
                   abbr[k][l]= Character.isLowerCase(a.charAt(k-1)) && abbr[k-1][l];
               }
               else if(Character.isUpperCase(a.charAt(k-1))){
                   abbr[k][l] = (a.charAt(k-1)==b.charAt(l-1)) && abbr[k-1][l-1];
               }
               else{
                   abbr[k][l] = (Character.toUpperCase(a.charAt(k-1))==b.charAt(l-1) && abbr[k-1][l-1]) || abbr[k-1][l];
               }
            }
        }
        return abbr[a.length()][b.length()]? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
