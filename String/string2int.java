class string2int{
	public static void main(String[] args) {
		System.out.println("123"+":"+convertstr2int("123"));
		System.out.println("-123"+":"+convertstr2int("-123"));
		System.out.println("--123"+":"+convertstr2int("--123"));

		System.out.println("a123"+":"+convertstr2int("a123"));
		System.out.println("12a3"+":"+convertstr2int("12a3"));
		System.out.println("0123"+":"+convertstr2int("0123"));

		System.out.println("2147483648"+":"+convertstr2int("2147483648"));
		System.out.println("2147483647"+":"+convertstr2int("2147483647"));
		System.out.println("-2147483649"+":"+convertstr2int("-2147483649"));

  //       int a = -2147483649;
		// System.out.println(a);
		
	}
	public static boolean pre_check(String str){
		if (str == null || str.length() < 1) {
			return false;
		}
		char[] carr = str.toCharArray();
		if (carr[0] != '-' && (carr[0] > '9' || carr[0] <'0')) {
			return false;
		}
		if (carr[0] == '-' && (carr.length == 1 || carr[1] == '0')) {
			return false;
		}
		if (carr[0] == '0' && carr.length > 1) {
			return false;
		}
		for (int i = 1; i < carr.length ;i++ ) {
			if (carr[i] > '9' || carr[i] < '0') {
				return false;
			}
		}
		return true;
	}

	public static int convertstr2int(String str){
		if (str == null || str.length() < 1) {
			return 0;
		}
		if (!pre_check(str)) {
			return 0;
		}

		char[] carr = str.toCharArray();

		boolean posi = carr[0] == '-' ? false : true;

		int res = 0;
		int cur = 0;

		int minFirstN  = Integer.MIN_VALUE / 10;
		int minLast1 = Integer.MIN_VALUE % 10;

		for (int i = posi==true ? 0 : 1 ; i < carr.length ; i++ ) {
			cur = '0' - carr[i];
			if (res < minFirstN || (res == minFirstN && cur < minLast1)) {
				return 0;
			}
			res = res * 10 + cur;
		}
		if (posi &&  res == Integer.MIN_VALUE) {
			return 0;
		}
		return posi ? (-1)*res : res;
	}
}