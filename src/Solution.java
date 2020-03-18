public class Solution {

    /*
    This is an O(n^2) solution
    */

    // a dynamic programing approach to solving the problem
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(200));
    }
    public static int solution(int n) {
        fill_stair_count();
        return stair_count[n][n] - TEMP_1;
    }

    // creating a static 2 dimensional array to hold values
    static int[][] stair_count = new int[201][201];
    static int TEMP_1 = 1;
    static int TEMP_2 = 2;

    // filling up the array
    public static void fill_stair_count() {
        // initial values
        stair_count[TEMP_1][TEMP_1] = TEMP_1;
        stair_count[TEMP_2][TEMP_2] = TEMP_1;

        // filling up the entire 2D array
        for (int stair_row = (TEMP_1 + TEMP_2); stair_row < (200 + TEMP_1); stair_row++) {
            for (int stair_col = TEMP_1; stair_col <= stair_row; stair_col++) {
                if (stair_row - stair_col == 0) {
                    stair_count[stair_row][stair_col] = TEMP_1 + stair_count[stair_row][stair_col - TEMP_1];
                } else if (stair_row - stair_col < stair_col) {
                    stair_count[stair_row][stair_col] = stair_count[stair_row - stair_col][stair_row - stair_col] + stair_count[stair_row][stair_col - TEMP_1];
                } else if (stair_row - stair_col == stair_col) {
                    stair_count[stair_row][stair_col] = stair_count[stair_col][stair_col - TEMP_1] + stair_count[stair_row][stair_col - TEMP_1];
                } else if (stair_row - stair_col > stair_col) {
                    stair_count[stair_row][stair_col] = stair_count[stair_row - stair_col][stair_col - TEMP_1] + stair_count[stair_row][stair_col - TEMP_1];
                }
            }
        }
    }


}