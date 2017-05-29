class c5_02_StringSubSum{
	public static void main(String[] args) {
		String str = "A-1B--2C--D6E";
		System.out.println(getSum(str));
	}
	public static int getSum(String str){
		if (str == null) {
			return 0;
		}
		char[] carr = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean pos = true;
		int cur = 0;
		for (int i = 0; i < carr.length; i++) {
			cur = carr[i] - '0';
			if (cur < 0 || cur > 9) {
				res = res + num;
				num = 0;
				if (carr[i] == '-') {
					if (i - 1 >= 0 && carr[i - 1] == '-' ) {
						pos = !pos;
					}else {
						pos = false;
					}
				}else {
					pos = true;
				}
			}else {
				num = num * 10 + (pos? cur : -cur);
			}
		}
		res = res + num;
		return res;
	}
}