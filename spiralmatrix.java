import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (across the top row)
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;

            // 2. Traverse Down (along the right column)
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                // 3. Traverse Left (across the bottom row)
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                // 4. Traverse Up (along the left column)
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
