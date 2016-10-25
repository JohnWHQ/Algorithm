import java.util.*;
class demo_use_map{
	public static void main(String[] args) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		String str = "abcdeabcdabcaba";
		use_hashmap_set(str.toCharArray(),map);
		use_hashmap_trace(map);


	}
	public static void use_hashmap_set(char[] carr,HashMap<Character,Integer> map){
		for (int i = 0 ; i < carr.length ; i++ ) {
			if (map.containsKey(carr[i])) {
				map.put(carr[i],map.get(carr[i])+1);
			}else {
				map.put(carr[i],1);
			}
		}
 	}

 	public static void use_hashmap_trace(HashMap<Character,Integer> map){
 		for (Map.Entry<Character,Integer> entry : map.entrySet() ) {
 			char key = entry.getKey();
 			int value = entry.getValue();
 			System.out.println("key:" + key + " " + "value:" + value);
 		}
 	}
}