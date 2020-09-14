/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SparseArray {

    private static int[] matchingStrings(List<String> strList, List<String> strQList) {
        Map<String,Integer> countMap = new HashMap<>();
        for(String str:strList){
            if(countMap.containsKey(str)){
                countMap.put(str, (countMap.get(str)+1));
            }
            else{
                countMap.put(str,1);
            }
        }
        int count[]=new int[strQList.size()];
        for(int i=0; i<strQList.size(); i++){
            if(countMap.containsKey(strQList.get(i))){
                count[i]=countMap.get(strQList.get(i));
            }
            else{
                count[i]=0;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> strings = new ArrayList<>(stringsCount);

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings.add(stringsItem);
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> queries = new ArrayList<>(queriesCount);

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries.add(queriesItem);
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
