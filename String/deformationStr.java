import java.util.*;
class deformationStr{
	public static void main(String[] args) {
		System.out.println(isDeformation("abcde12312","ebcda12315"));
	}
	public static boolean isDeformation(String str1 ,String str2){

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		for (int i = 0 ; i < carr1.length; i++ ) {
			if (hm.containsKey(carr1[i])) {
				hm.put(carr1[i],hm.get(carr1[i])+1);
			}else{
				hm.put(carr1[i],1);
			}
		}
		for (int i = 0 ; i < carr2.length; i++) {
			if (hm.containsKey(carr2[i])) {
				hm.put(carr2[i],hm.get(carr2[i])-1);
			}else{
				return false;
			}
		}
        int tmp ;
		for (Map.Entry<Character,Integer> entry :  hm.entrySet()) {
			tmp = (int)entry.getValue();
			if (tmp != 0) {
				return false;
			}
		}
		return true;
	}
}