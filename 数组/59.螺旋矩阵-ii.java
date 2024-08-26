/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startx = 0, starty = 0;
        int loop = 0;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i, j;
        while (loop++ < n / 2) {
            for (j = starty; j < n - offset; j++) {
                result[startx][j] = count;
                count++;
            }
            for (i = startx; i < n - offset; i++) {
                result[i][j] = count;
                count++;
            }
            for (; j > starty; j--) {
                result[i][j] = count;
                count++;
            }
            for (; i > startx; i--) {
                result[i][j] = count;
                count++;
            }
            startx++;
            starty++;
            offset++;
        }
        if (n % 2 == 1) {
            result[mid][mid] = count;
        }
        return result;
    }
}
// @lc code=end
