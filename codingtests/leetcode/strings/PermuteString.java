package codingtests.leetcode.strings;

public class PermuteString {
	
	public static void main(String[] args) {
		assert permutation("Hello").equals("olleH");
	}

	private static String permutation(String str) {
		return permutation(str, "");
	}

	private static String permutation(String str, String prefix) {
		String result = prefix;
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				result = permutation(rem, prefix + str.charAt(i));
			}
		}
		return result;
	}
}
