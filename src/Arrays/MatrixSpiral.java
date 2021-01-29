/**
 *
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 *
 */
class MatrixSprial{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top  = 0; int bottom = matrix.length - 1 ;
        int left = 0; int right = matrix[0].length - 1;
        int direction = 1;
        while(top <= bottom && left <= right){
            if(direction == 1){
                for(int i = left; i <= right; i++ ){
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 2;
            }
            else if(direction == 2){
                for(int i = top; i <= bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                direction = 3;
            }
            else if(direction == 3){
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 4;
            }
            else if(direction == 4){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 1;
            }
        }
        return result;
    }
}