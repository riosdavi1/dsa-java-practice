package codingtests.leetcode.arrays;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/richest-customer-wealth/description/
 */
public class RichestCustomerWealth {

    public static void main(String[] args) {
        assert maximumWealth(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }) == 6;
        assert maximumWealth(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }) == 10;
        assert maximumWealth(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }) == 17;
    }

    private static int maximumWealth(int[][] accounts) {
        int richestWealth = 0;
        for (int[] account : accounts) {
            int wealth = Arrays.stream(account).sum();
            if (wealth > richestWealth) {
                richestWealth = wealth;
            }
        }
        return richestWealth;
    }
}
