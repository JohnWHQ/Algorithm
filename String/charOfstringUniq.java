import java.util.*;
class charOfstringUniq{
	public static void main(String[] args) {
		char[] carr = {'a','b','c','a'};
	    System.out.println(is_unique_1(carr));
	    System.out.println(is_unique_2(carr));
		
	}

	//first method use the char array to unique
	public static boolean is_unique_1(char[] carr){
		boolean[] check = new boolean[256];
		for (int i = 0;i < carr.length ; i++ ) {
			if (check[carr[i]]) {
				return false;
			}else{
				check[carr[i]] = true;
			}
		}
		return true;
	}
	// second method use the hashmap to unique
	public static boolean is_unique_2(char[] carr){
		HashMap<Character,Integer> check = new HashMap<Character,Integer>();
		for (int i = 0;i < carr.length ; i++ ) {
			if (check.containsKey(carr[i])) {
				return false;
			}else{
				check.put(carr[i],0);
			}
		}
		return true;
	}
}