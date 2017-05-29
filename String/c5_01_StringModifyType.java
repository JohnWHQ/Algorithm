class c5_01_StringModifyType{
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "aacd";
		System.out.println(isModifyString(str1, str2));
	}
	public static boolean isModifyString(String str1, String str2){
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		int[] map = new int[256];
		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		for (int i = 0; i < carr1.length; i++) {
			map[carr1[i]]++;
		}
		for (int i = 0; i < carr2.length; i++) {
			map[carr2[i]]--;
			if (map[carr2[i]] < 0) {
				return false;
			}
		}
		return true;
	}
}