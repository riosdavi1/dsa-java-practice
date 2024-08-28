package codingtests.codinginterview.strings;

public class OneEditAway {

	public static void main(String[] args) {
		assert isOneAway("pale", "ple");
		assert isOneAway("pales", "pale");
		assert !isOneAway("pale", "bake");
		assert isOneAway("pale", "pales");
		assert !isOneAway("pal", "pales");
	}

	/*
	 * a:"pale", b:"ple" if (b.length == b.length - 1) -> chars:[p:1, a:1, l:1, e:1]
	 * -> chars:[p:0, a:1, l:0, e:0] -> sum=1 -> true
	 * 
	 * a:"pale", b:"bale" if (b.length == a.length) -> chars:[p:1, a:1, l:1, e:1] ->
	 * chars:[p:1, a:0, l:0, e:0] -> sum=0 -> true
	 * 
	 * a:"pale", b:"bake" if (b.length == a.length) -> chars:[p:1, a:1, l:1, e:1] ->
	 * chars:[p:1, a:0, l:1, e:0] -> sum=2 -> false
	 * 
	 * a:"pale", b:"pales" if (b.length == a.length + 1) -> chars:[p:1, a:1, l:1,
	 * e:1] -> chars:[p:0, a:0, l:0, e:0] -> sum=0 -> true
	 * 
	 * a:"pal", b:"pales" else -> false
	 */
	private static boolean isOneAway(String a, String b) {
		if (b.length() < a.length() - 1 || b.length() > a.length() + 1) {
			return false;
		}

		int[] chars = new int[128];

		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			chars[c]++;
		}

		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			chars[c]--;
		}

		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 0)
				sum++;
		}

		if ((sum == 1 && b.length() == a.length() - 1)
				|| (sum == 0 && (b.length() == a.length() || b.length() == a.length() + 1))) {
			return true;
		}
		
		return false;
	}
}
