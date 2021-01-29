/**
 *
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 */
class  MatrixSpiral2{
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n] ;
        int top  = 0; int bottom = n - 1 ;
        int left = 0; int right = n - 1;
        int direction = 1; int num = 1;
        while(top <= bottom && left <= right){
            if(direction == 1){
                for(int i = left; i <= right; i++ ){
                    result[top][i] = num++;
                }
                top++;
                direction = 2;
            }
            else if(direction == 2){
                for(int i = top; i <= bottom; i++){
                    result[i][right] = num++;
                }
                right--;
                direction = 3;
            }
            else if(direction == 3){
                for(int i = right; i >= left; i--){
                    result[bottom][i] = num++;
                }
                bottom--;
                direction = 4;
            }
            else if(direction == 4){
                for(int i = bottom; i >= top; i--){
                    result[i][left] = num++;
                }
                left++;
                direction = 1;
            }
        }
        return result;
    }
}