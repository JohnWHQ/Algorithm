class rotateStr{
	public static void main(String[] args) {
		// String s1 = "aaaaabcdabceabcdeagh";
		// String s2 = "abcdabceabcdeag";
		// System.out.println(getIndexOf(s1,s2));
		String s1 = "abcdefghijk";
		String s2 = "fghijkabcde";
		System.out.println(isRotation(s1,s2));
	}
	
	public static boolean isRotation(String str1,String str2){
		if (str1 == null || str2 == null || str1.length()<1 || str2.length()<1 || str1.length() != str2.length()) {
			return false;
		}
		String str = str1 + str1;
		return getIndexOf(str,str2) == -1 ? false : true;
	}

	public static int getIndexOf(String str, String match){
		if (str == null || match == null || match.length() < 1 || str.length() < match.length()) {
			return -1;
		}
		char[] str_arr = str.toCharArray();
		char[] match_arr = match.toCharArray();

		int[] next = getNextArr(match_arr);
 
		int i = 0;
		int j = 0;

		while (i < str_arr.length && j < match_arr.length) {
			if (str_arr[i] == match_arr[j]) {
				i++;
				j++;
			}else if (next[j] == -1) {
				i++;
			}else{
				j = next[j];
			}
		}
		return j == match_arr.length ? i - j : -1;
	}

	public static int[] getNextArr(char[] arr){
		if (arr.length == 1) {
			return new int[]{-1};
		}
		int[] next = new int[arr.length];

		next[0] = -1;
		next[1] = 0;

		int i = 2;
		int x = 0;

		while(i < arr.length){
			if (arr[i-1] == arr[x]) {
				next[i++] = ++x;
			}else if (x > 0) {
				x = next[x];
			}else{
				next[i++] = 0;
			}
		}
		return next;
	}

}  