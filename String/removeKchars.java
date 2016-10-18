class removeKchar{
	public static void main(String[] args) {
		// String str = "AOOOOBOOO";
		// System.out.println(removeKchar(str,3,'O'));

		// char[] carr = new char[]{'0',0,'0'};
		// System.out.println(new String(carr));

		
	}

	public static String removeKchar(String str,int k,char c){
		if (str == null || str.length() < k || k<1) {
			return str;
		}
		int start = -1;
		int count = 0;

		char[] res = str.toCharArray();
		for (int i = 0; i < res.length ;i++ ) {
			if (res[i] == c) {
				count++;
				start = start == -1 ? i : start;
			}else {
				if (count == k) {
					while (count != 0) {
						res[start++] = 0;
						count--;
					}
				}
				count = 0;
				start = -1;	
			}
		}
		if (count == k) {
			while (count != 0) {
				res[start++] = 0;
				count--;
			}
		}
		return new String(res);		
	}
}