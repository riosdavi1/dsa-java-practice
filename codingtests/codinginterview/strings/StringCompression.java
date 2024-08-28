package codingtests.codinginterview.strings;

public class StringCompression {

	public static void main(String[] args) {
		assert compress("aabcccccaaa").equals("a2b1c5a3");
		assert compress("aa").equals("aa");
		assert compress("aab").equals("aab");
		assert compress("aabbb").equals("a2b3");
	}

	private static String compress(String s) {
		if (s == null || s.length() == 2) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int prev = s.charAt(0);
		int sum = 1;
		for (int i = 1; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == prev) {
				sum++;
			} else {
				sb.append((char)prev).append(sum);
				sum = 1;
				prev = current;
			}
		}

		sb.append((char)prev).append(sum);		
		String r = sb.toString();

		return r.length() < s.length() ? r : s;
	}
}
