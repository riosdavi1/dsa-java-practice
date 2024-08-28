package codingtests.leetcode.lists;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/description/
 */
public class FizzBuzz {

    public static void main(String[] args) {
        assert fizzBuzz(3).toString().equals("[1, 2, Fizz]");
        assert fizzBuzz(5).toString().equals("[1, 2, Fizz, 4, Buzz]");
        assert fizzBuzz(15).toString().equals("[1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]");
    }

    private static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String value = "";
            if (i % 3 == 0) {
                value = "Fizz";
            }
            if (i % 5 == 0) {
                value += "Buzz";
            }
            if (value.isEmpty()) {
                value = String.valueOf(i);
            }
            answer.add(value);
        }
        return answer;
    }
}
