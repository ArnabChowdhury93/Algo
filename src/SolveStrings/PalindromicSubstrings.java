/**
 *
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 */
class PalindromicSubstrings{
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += findPalindromicSubstrings(s, i , i);
            count += findPalindromicSubstrings(s, i , i+1);
        }
        return count;
    }
    private int findPalindromicSubstrings(String str, int left, int right){
        int count = 0;
        while(left >= 0 && right < str.length()){
            if(str.charAt(left--) != str.charAt(right++)){
                break;
            }
            count++;
        }
        return count;
    }
}