package codingtests.leetcode.strings;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/description/
 */
public class RansomNote {

    public static void main(String[] args) {
        assert !canConstruct("a", "b");
        assert !canConstruct("aa", "ab");
        assert canConstruct("aa", "aab");
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        // Function will return as soon as there is no more characters in magazine,
        // so time complexity is O(m), where m is equal to maganize.length().
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // The map will contain as many different entries as different characters
        // in the alphabet, which is a constant value equals to 26.
        // Therefore, space complexity is O(1).
        Map<Character, Integer> magazineCounter = new HashMap<>();
        // magazine.toCharArray would create a new copy
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineCounter.put(c, magazineCounter.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int count = magazineCounter.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            magazineCounter.put(c, --count);
        }
        return true;
    }
}
