class KMP{
	public static void main(String[] args) {
		String s1 = "aaaaabcdabceabcdeagh";
		String s2 = "abcdabceabcdeag";
		System.out.println(getIndexOf(s1,s2));

		int[] arr = getNextArr(s2.toCharArray());

   //      for (int x : arr) {
			// System.out.println(x);        	
   //      }

	}
	public static int getIndexOf(String str,String match){
		if (str == null || match == null || match.length() > str.length()) {
			return -1;				
		}
		char[] str_arr = str.toCharArray();
		char[] match_arr = match.toCharArray();

		int[] next_arr = getNextArr(match_arr);

		int i = 0;
		int j = 0;
		while (i < str_arr.length && j < match_arr.length) {
			if (str_arr[i] == match_arr[j]) {
				i++;
				j++;
			}else if (next_arr[j] == -1) {
				i++;
			}else{
				j = next_arr[j];
			}
		}
		return j == match_arr.length ? i - j : -1;
	}
	public static int[] getNextArr(char[] arr){

		if (arr.length == 1) {
			return new int[]{-1};
		}

		int[] res = new int[arr.length];

		res[0] = -1;
		res[1] = 0;

		int i = 2;
		int x = 0;

		while(i < arr.length){
			if (arr[i-1] == arr[x]) {
				res[i++] = ++x;
			}else if (x > 0){
				x = res[x];
			}else{
				res[i++] = 0;
			}
		}
		return res;
	}
}