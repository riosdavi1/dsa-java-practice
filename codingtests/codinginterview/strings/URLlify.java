package codingtests.codinginterview.strings;

public class URLlify {

	public static void main(String[] args) {
		assert urlify("Mr John Smith                      ", 13).equals("Mr%20John%20Smith");
	}

	/*
	 * "Mr John Smith"
	 * "Mr"
	 * "Mr%20"
	 * "Mr%20John"
	 * "Mr%20John%20"
	 * "Mr%20John%20Smith"
	 * "Mr%20John%20Smith"
	 */
	private static String urlify(String s, int trueLength) {
		char[] chars = s.toCharArray();
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		if (trueLength < chars.length) chars[trueLength] = '\0';
		int index = trueLength + spaceCount * 2;
		char[] result = new char[index];
		for (int i = trueLength - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				result[index - 1] = '0';
				result[index - 2] = '2';
				result[index - 3] = '%';
				index -= 3;
			} else {
				result[index - 1] = chars[i];
				index--;
			}
		}
		
		/*
		int i = 0;
		while (i < chars.length) {
			if (chars[i] == ' ') {
				chars[i] = '%';
				for (int j = chars.length - 1; j > i + 2; j--) {
					chars[j] = chars[j-2];
				}
				chars[i+1] = '2';
				chars[i+2] = '0';
				i += 3;
			} else {
				i++;
			}
		}
		*/
		
		return new String(result);
	}
}
