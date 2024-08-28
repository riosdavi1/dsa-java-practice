package codingtests.leetcode.strings;
/**
 * https://leetcode.com/problems/is-subsequence/description/
 */
class IsSubsequence {

    public static void main(String[] args) {
        assert isSubsequence("abc", "ahbgdc");
        assert !isSubsequence("axc", "ahbgdc");
        /*
         * 1. c:'a', i:0 -> i=1
         * 2. c:'b', i:1 -> i=3
         * 3. c:'c', i:3 -> i=6
         * true
         * 
         * 1. c:'a', i:0 -> i=1
         * 2. c:'x', i:1 -> false
         */
    }

    private static boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == s.length();
    }
}