package codingtests.leetcode.arrays;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/description/
 */
public class RunningSumOf1dArray {

    public static void main(String[] args) {
        assert Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })).equals("[1, 3, 6, 10]");
        assert Arrays.toString(runningSum(new int[] { 1, 1, 1, 1, 1 })).equals("[1, 2, 3, 4, 5]");
        assert Arrays.toString(runningSum(new int[] { 3, 1, 2, 10, 1 })).equals("[3, 4, 6, 16, 17]");
    }

    private static int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        return sums;
    }
}
