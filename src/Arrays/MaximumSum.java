/**
 * Maximum Sum
 * 
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm
 * /maximum-sum-4-f8d12458/description/
 */
class MaximumSum { 
    
    private static Scanner sc;
 
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++){
			a[i]=sc.nextInt();
		}
		printMaxSubArray(a,n);
	}
 
	private static void printMaxSubArray(int[] a, int n) {
	    long maxSum;
		int maxCounter, max;
		maxSum = 0; maxCounter= 0; max=a[0];
		
		for(int i=0; i<n; i++){
		    if(max<a[i]){
		        max=a[i];
		    }
		    if(maxSum<=maxSum+a[i]){
		        maxSum+=a[i];
		        maxCounter++;
		    }
		}
		if(maxSum==0 && max<0){
		   maxSum=max;
		   maxCounter=1;
		}
		System.out.print(maxSum+" "+maxCounter);
	}
}