package codingtests.codinginterview.strings;

/**
 * This solution is better than the one in the book.
 * 
 * @author riosd
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		assert !isPalindrome(null);
		assert !isPalindrome("");
		assert !isPalindrome("T");
		assert isPalindrome("Tact Coa");
		assert !isPalindrome("Tact Coaa");
		assert isPalindrome("TactCoa");
		assert !isPalindrome("TactCoaa");
		assert !isPalindrome("TactCoamn");
	}

	/*
	 * "Tact Coa" -> "tactcoa" -> 1. chars[t:2, a:2, c:2, o:1]
	 * 
	 */
	private static boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return false;
		}
		
		int spaceCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				spaceCount++;
			}
		}

		int[] chars = new int[128];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (c >= 65 && c <= 90) { // A..Z character?
				c += 32;
			}
			chars[c]++;
		}
		
		boolean oddCount = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ' && chars[c] % 2 == 1) {
				if ((s.length() - spaceCount) % 2 == 0) {
					return false;
				}
				if (oddCount) {
					return false;
				} else {
					oddCount = true;
				}
			}
		}

		return true;
	}
}
