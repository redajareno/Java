/**
 * Project 27.1
 * 
 * Create a new class that implements the MyMap interface (attached, from LiveExample 27.1)
 * using open addressing with quadratic probing. For simplicity, use f(key) = key % size as 
 * the hash function, where size is the hash-table. Initially, the hash-table size is 4. 
 * The table size is doubled whenever the load factor exceeds the threshold (0.5).
 * You can refer to the MyHashMap.java class in LiveExample 27.2 as you are working 
 * on your own hash map class.
 * 
 * Create a Test/Demo class that tests/demonstrates your class. 
 * This can be similar to the TestMyHashMap.java class in LiveEample 27.3, 
 * or you can write your own. Just be sure that it tests out the methods in 
 * your hash map class.
 * 
 * @author Reno Redaja
 *
 */
public class Project271 {
    public static void main(String[] args) {
		MyMap<String, Integer> map = new MyHashMap<>();
		map.put("Lewandowski", 30);
	    map.put("Messi", 31);
		map.put("Ronaldo", 29);
		map.put("Trent", 29);
		map.put("Bale", 21);
		map.put("Benzema", 21);
		map.put("Frankie", 65);
		map.put("Riqui", 21);

		System.out.println("Entries in map: " + map);

		System.out.println("The age of Ronaldo is " +
			map.get("Ronaldo"));

		System.out.println("The age of Messi is " +
			map.get("Messi"));

		System.out.println("Is Riqui in the map? " +
			map.containsKey("Riqui"));

		System.out.println("Is Frankie in the map? " +
			map.containsKey("Frankie"));

		System.out.println("Is age 17 in the map? " +
			map.containsValue(17));

		System.out.println("Is age 65 in the map? " +
			map.containsValue(65));

		System.out.print("Keys in map: ");
		for (String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();

		System.out.print("Values in map: ");
		for (int value : map.values()) {
			System.out.print(value + " ");
		}
		System.out.println();

		map.remove("Riqui");
		System.out.println("Entries in map " + map);

		map.clear();
		System.out.println("Entries in map " + map);
    } //end main method
} //end Project271 class