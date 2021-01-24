/**
 * https://leetcode.com/problems/happy-number/submissions/
 * 202. Happy Number
 */
class HappyNumber{
    public boolean isHappy(int n) {
        int fast = n; int slow = n;
        do{
            fast = digitSquaredSum(digitSquaredSum(fast));
            slow = digitSquaredSum(slow);
        }while(fast != slow);

        return slow == 1;
    }
    private int digitSquaredSum(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit*digit;
            num /= 10;
        }
        return sum;
    }
}