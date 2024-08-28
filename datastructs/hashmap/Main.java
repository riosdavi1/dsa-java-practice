package datastructs.hashmap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("David", 51);
		map.put("Sole", 44);
		map.put("Manu", 18);
		assert map.get("David") == 51;
		assert map.get("Manu") == 18;
		assert map.get("Male") == null;
		assert map.get("Sole") == 44;
		map.remove("Sole");
		assert map.get("Sole") == null;
	}
}
