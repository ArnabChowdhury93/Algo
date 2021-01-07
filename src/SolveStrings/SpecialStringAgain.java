/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem
 */
public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int length, String s) {
        List<Character> ch = new ArrayList<>();
        List<Long> count = new ArrayList<>();
        
        long counter = 1;
        char pointer = s.charAt(0);
        for(int i=1; i<length; i++){
            if(pointer==s.charAt(i)){
                counter++;
            }
            else{
                ch.add(pointer);
                count.add(counter);
                counter=1;
                pointer=s.charAt(i);
            }
        }
        ch.add(pointer);
        count.add(counter);
        counter=(count.get(0)*(count.get(0)+1))/2;
        if(count.size()==2){
            counter+=(count.get(1)*(count.get(1)+1))/2;;
        }
        else if(count.size()>=3){
            for(int i=1; i<count.size(); i++){
                if(count.get(i)==1 && i!=(count.size()-1) && ch.get(i-1)==ch.get(i+1) ){
                    counter++;
                    counter+=((count.get(i-1)>count.get(i+1))?count.get(i+1):count.get(i-1));
                }
                else{
                    counter+=(count.get(i)*(count.get(i)+1))/2;;
                }
            }
        }
        
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
