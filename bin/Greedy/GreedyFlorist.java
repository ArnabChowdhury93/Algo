/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 */
class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int cost = 0;
        int costIncrementor=1;
        
        int i = c.length-1;
        while(i>=0){
            for(int j=0; j<k && i>=0; j++){
                cost+=c[i]*costIncrementor;
                i=i-1;
            }
            costIncrementor++;
        }

        return cost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
