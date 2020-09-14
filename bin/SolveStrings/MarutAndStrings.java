/**
 * 
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/
 * practice-problems/algorithm/marut-and-strings-4/
 */
class MarutAndStrings {
    private static Scanner sc;
 
    public static void main(String[] args) {
		sc = new Scanner(System.in);
		String testCase = sc.nextLine();
		if(testCase.charAt(0) > '0' && testCase.charAt(0) < '9' && Integer.valueOf(testCase)<=10){
			for(int i=0;i<Integer.valueOf(testCase);i++){
				String input = sc.nextLine();
				if(100>=input.length()){
					printOperations(input);
				}
				else{
					System.out.println("Invalid Input");
				}
			}
		}
		else{
			System.out.print("Invalid Test");
		}
		
	}
 
	private static void printOperations(String nextLine) {
		int upperCases, lowerCases;
		upperCases=0; lowerCases=0;
		for(int i=0; i<nextLine.length(); i++){
			if(65<=((int)nextLine.charAt(i)) && ((int)nextLine.charAt(i))<=90){
				upperCases++;
			}
			else if(97<=((int)nextLine.charAt(i)) && ((int)nextLine.charAt(i))<=122){
				lowerCases++;
			}
		}
		if(upperCases==0 && lowerCases==0){
			System.out.println("Invalid Input");
		}
		else{
			System.out.println(Math.min(lowerCases, upperCases));
		}
	}
}