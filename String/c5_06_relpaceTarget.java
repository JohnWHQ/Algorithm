class c5_06_relpaceTarget{
	public static void main(String[] args) {
		
	}
	public static String replace(String str, String from, String to){
		if (str == null || from == null || str.length() == 0 || from.length() == 0) {
			return str;
		}
		char[] sarr = str.toCharArray();
		char[] farr = from.toCharArray();
		int index = 0;
		for (int i = 0; i < sarr.length; i++) {
			if (sarr[i] == farr[index++]) {
				if (index == farr.length) {
					for (int j = i; j > i - farr.length; j--) {
						sarr[j] = 0;
					}
					index = 0;
				}
			}else {
				index = 0;
			}
		}
		String res = "";
		String cur = "";
		for (int i = 0; i < sarr.length; i++) {
			if (sarr[i] != 0) {
				cur = cur + String.valueOf(sarr[i]);
			}
			if (sarr[i] == 0 && (i == 0 || sarr[i - 1] != 0)) {
				res = res + cur + to;
			}
		}
		if (cur.length() != 0) {
			res = res + cur;
		}
		return res;
	}
}