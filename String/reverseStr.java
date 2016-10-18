import java.util.*;
class reverseStr{
	public static void main(String[] args) {
		System.out.println(reverse("abcde"));
		System.out.println(reverse_lowB("abcde"));
		
	}
	public static String reverse(String str){
		if (str == null || str.length() <= 1) {
			return str;
		}
		char[] carr = str.toCharArray();
		int h = 0;
		int t = carr.length-1;
		char tmp;
		while(h<t){
			tmp = carr[h];
			carr[h] = carr[t];
			carr[t] = tmp;
			h++;
			t--;
		}
		return new String(carr);
	}
	public static String reverse_lowB(String str){
		if (str == null || str.length() <= 1) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
	    char[] carr = str.toCharArray();
	    for (int i = carr.length - 1; i >= 0 ; i-- ) {
	    	sb.append(carr[i]);
	    }		
	    return sb.toString();
	}
}