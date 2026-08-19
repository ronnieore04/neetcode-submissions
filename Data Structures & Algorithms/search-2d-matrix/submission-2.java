class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int x, y;
        int[] located = null;
        for (int i = 0; i < matrix.length; i++) {
            x = matrix[i][0];
            y = matrix[i][matrix[0].length - 1];
            if (target <= y && target >= x) {
                located = matrix[i];
                break;
            }
        }
        if (located == null) return false;
        return Arrays.binarySearch(located, target) >= 0 ? true : false;
    }
}
