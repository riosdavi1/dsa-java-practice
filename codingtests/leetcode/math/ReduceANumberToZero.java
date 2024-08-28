package codingtests.leetcode.math;
/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */
public class ReduceANumberToZero {

    public static void main(String[] args) {
        assert numberOfSteps(14) == 6;
        assert numberOfSteps(8) == 4;
        assert numberOfSteps(123) == 12;
    }

    private static int numberOfSteps(int num) {
        int steps = 0;
        int current = num;
        while (current > 0) {
            steps++;
            if (current % 2 != 0) {
                current--;
            } else {
                current /= 2;
            }
        }
        return steps;
    }
}
