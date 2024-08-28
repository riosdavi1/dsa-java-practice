package codingtests.codinginterview.strings;

public class CheckPermutation {

	public static void main(String[] args) {
		assert isPermutation("holaa", "aloha");
		assert !isPermutation("hola", "lalo");
	}

	/*
	 * a="holaa", b="aloha"
	 * 1. a[0]:h -> chars[h]=1
	 * 2. a[1]:o -> chars[h]=1, chars[o]=1
	 * 3. a[2]:l -> chars[h]=1, chars[o]=1, chars[l]=1
	 * 4. a[3]:a -> chars[h]=1, chars[o]=1, chars[l]=1, chars[a]=1
	 * 5. a[4]:a -> chars[h]=1, chars[o]=1, chars[l]=1, chars[a]=2
	 * 6. b[0]:a -> chars[h]=1, chars[o]=1, chars[l]=1, chars[a]=1
	 * 7. b[1]:l -> chars[h]=1, chars[o]=1, chars[l]=0, chars[a]=1
	 * 7. b[2]:o -> chars[h]=1, chars[o]=0, chars[l]=0, chars[a]=1
	 * 7. b[3]:h -> chars[h]=0, chars[o]=0, chars[l]=0, chars[a]=1
	 * 7. b[4]:a -> chars[h]=0, chars[o]=0, chars[l]=0, chars[a]=0 -> true
	 * 
	 * a="hola", b="lalo"
	 * 1. a[0]:h -> chars[h]=1
	 * 2. a[1]:o -> chars[h]=1, chars[o]=1
	 * 3. a[2]:l -> chars[h]=1, chars[o]=1, chars[l]=1
	 * 4. a[3]:a -> chars[h]=1, chars[o]=1, chars[l]=1, chars[a]=1
	 * 6. b[0]:l -> chars[h]=1, chars[o]=1, chars[l]=0, chars[a]=1
	 * 7. b[1]:a -> chars[h]=1, chars[o]=1, chars[l]=0, chars[a]=0
	 * 7. b[2]:l -> chars[h]=1, chars[o]=1, chars[l]=-1 -> false
	 */
	private static boolean isPermutation(String a, String b) {
		if (a == null || a == "" || b == null || b == "") {
			return false;
		}

		if (a.length() != b.length()) {
			return false;
		}

		int[] chars = new int[128];
		for (int i = 0; i < a.length(); i++) {
			int c = a.charAt(i);
			chars[c]++;
		}

		for (int i = 0; i < b.length(); i++) {
			int c = b.charAt(i);
			if (chars[c] == 0) {
				return false;
			}
			chars[c]--;
		}

		return true;
	}
}
