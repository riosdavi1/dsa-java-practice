package datastructs.arraylist;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("David");
		assert list.get(0).equals("David");
		list.remove(0);
		assert list.size() == 0;
		list.add("Sole");
		list.add("Male");
		assert list.get(1).equals("Male");
		assert list.get(0).equals("Sole");
		try {
			list.get(2);
			assert false;			
		} catch (IndexOutOfBoundsException e) {
		}
		list.remove("Male");
		assert list.size() == 1;
		assert list.get(0).equals("Sole");
	}
}
