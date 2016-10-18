class StringTools{
	public static void main(String[] args) {
		
	}


	/**
	 *@desc KMP match string and return index
	 *@param str (the string be matched) match (the string to match)
	 *@return if match return index , or -1
	 */
	public static int getIndexOf(String str ,String match){
		if (str == null || match == null || str.length()<1 || match.length()>str.length) {
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
			}else if (next[j] != -1) {
				j = next[j];
			}else {
				j++;
			}
		}
		return j == match_arr.length ? i - j : -1;
	}

	/**
	 *@desc KMP next Array
	 *@param  char[] carr
	 *@return next Array
	 */
	public static int[] getNextArr(char[] arr){
		if (arr.length == 1) {
			return new int[]{-1} ;
		}

		int[] next = new int[arr.length];
		next[0] = -1;
		next[1] =  0;

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

	/**
	 *@desc judge is rotation  eg: abcde -> cdeab return ture
	 *@param  String str , String match eg: abcde -> cdeab 
	 *@return true | false
	 */
	public static boolean isRotation(String str , String match){
		if (str == null || match == null || str.length() != match.length() || str.length < 1) {
			return false;
		}
		String s = str + str;

		return getIndexOf(s,match) == -1 ? false : true ;

	}

	/**
	 *@desc reverse string  eg: input abcde  out put edcba
	 *@param  String str
	 *@return reversed str
	 */	

	public static String reveseString(String target){
		if (target == null || target.length() <= 1) {
			return target;
		}
		char[] carr = target.toCharArray();

		int start = 0;
		int end = carr.length - 1;

		char tmp ;

		while(start < end ){
			tmp = carr[start];
			carr[start] = carr[end];
			carr[end] = tmp;
			start++;
			end++;
		}
		return new String(carr);
	}

	/**
	 *@desc reverse string  eg: input abcde  out put edcba
	 *@param  String str
	 *@return reversed str
	 */	

	// public static String reverse_lowB(String str){
	// 	if (str == null || str.length() <= 1) {
	// 		return str;
	// 	}
	// 	StringBuilder sb = new StringBuilder();
	//     char[] carr = str.toCharArray();
	//     for (int i = carr.length - 1; i >= 0 ; i-- ) {
	//     	sb.append(carr[i]);
	//     }		
	//     return sb.toString();
	// }	

	


}