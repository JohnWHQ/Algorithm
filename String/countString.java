class countString{
	public static void main(String[] args) {

		System.out.println(getCountString("aaabbadddffc"));

		System.out.println(getCharAt("a_100_b_2_c_4",105));	
	}
	public static String getCountString(String str){
		if (str == null || str.length() < 1) {
			return str;
		}
		char[] carr = str.toCharArray();
		String res = String.valueOf(carr[0]);
		int num  = 1;
		for (int i = 1;i < carr.length ;i++ ) {
			if (carr[i] == carr[i-1]) {
				num++;
			}else {
				res = res + "_" + num + "_" + String.valueOf(carr[i]);
				num = 1;
			}
		}
		res = res + "_" + num;
		return res;
	}
	public static char getCharAt(String str ,int index){
		if (str == null || str.length() < 1) {
			return 0;
		}

		char[] carr = str.toCharArray();

		char cur = 0;
		int num = 0;
		int sum = 0;
		boolean flag = true;
		for (int i = 0; i < carr.length ; i++ ) {
			if (carr[i] == '_' ) {
				flag = !flag;
			}else if (flag) {
				sum = sum + num ;
				if (sum > index) {
					return cur;
				}
				cur = carr[i];
				num = 0;
			}else {
				num = num * 10 + carr[i] - '0';
			}
		}
		return sum + num > index ? cur : 0;
	}
}