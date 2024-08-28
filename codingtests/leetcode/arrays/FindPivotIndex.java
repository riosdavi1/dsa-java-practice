package codingtests.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        assert getPivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }) == 3;
        assert getPivotIndex(new int[] { 1, 2, 3 }) == -1;
        assert getPivotIndex(new int[] { 2, 1, -1 }) == 0;
    }

    private static int getPivotIndex(int[] nums) {
        int leftSum = 0;
        int arraySum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == arraySum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
