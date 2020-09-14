/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String str) {
        int count[] = new int[26];
        for(int i=0; i<str.length(); i++){
            count[((int)str.charAt(i))-97]++;
        }
        boolean valid = true;
        int commonFreq=count[0];
        for(int i=1; i<26; i++){
            if(count[i]!=0 && !(commonFreq==count[i])){
                if(valid){
                    if(commonFreq<count[i]){
                        count[i]--;i--;
                        valid=false;
                        continue;
                    }
                    else{
                        if(count[i]==1){
                            count[i]--;
                            i--;
                            valid=false;
                            continue;
                        }
                        if(i>1){
                            return "NO";
                        }
                    }
                }
                else{
                    return "NO";
                }
                
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
