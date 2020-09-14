import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
public class IceCreamParlour {

    static void whatFlavors(int[] cost, int money) {
         Map<Integer, Integer> costMap = new HashMap<>();
         for(int i=0; i<cost.length;i++){
             int leftOverMoney = money- cost[i];
             if(costMap.containsKey(leftOverMoney)){
               System.out.println((costMap.get(leftOverMoney)+1)+" "+(i+1));
             }
             costMap.put(cost[i], i);
         }
 
     }
 
     private static final Scanner scanner = new Scanner(System.in);
 
     public static void main(String[] args) {
         int t = scanner.nextInt();
         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
         for (int tItr = 0; tItr < t; tItr++) {
             int money = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
             int n = scanner.nextInt();
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
             int[] cost = new int[n];
 
             String[] costItems = scanner.nextLine().split(" ");
             scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
 
             for (int i = 0; i < n; i++) {
                 int costItem = Integer.parseInt(costItems[i]);
                 cost[i] = costItem;
             }
 
             whatFlavors(cost, money);
         }
 
         scanner.close();
     }
 }
 