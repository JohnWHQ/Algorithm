class findfrom2to{
	public static void main(String[] args) {
		String str = "abcdefxyzadcdefxyzXYZ";
		String from = "xyz";

		System.out.println(find_from_2_to(str,from,"1234"));
		
	}
	public static String find_from_2_to(String str , String from ,String to){
		if (str == null || from == null || str.length() < 1 || from.length() < 1 || 
			str.length() < from.length()) {
			return  str;
		}

		char[] str_arr = str.toCharArray();
		char[] from_arr = from.toCharArray();


		int index = 0;
		int tmp;

		for (int i = 0; i < str_arr.length ; i++ ) {
			if (str_arr[i] == from_arr[index]) {
				index++;
				if (index == from_arr.length) {
					tmp = i - index;
					while (tmp < i) {
						str_arr[++tmp] = 0;
					}
					index = 0;
				}
			}else {
				index = 0;
			}
		}

		String res = "";
		String cur = "";

		// make the char to String the standard Convert Function
		for (int i=0; i < str_arr.length ; i++ ) {
			if (str_arr[i] != 0) {
				cur = cur + String.valueOf(str_arr[i]);
			}
			if (str_arr[i] == 0 && (i == 0 || str_arr[i-1] != 0)) {
				res = res + cur + to;
				cur = "";
			}
		}

		if (!cur.equals("")) {
			res = res + cur;
		}		

		return res;
	}
}