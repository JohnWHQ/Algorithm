class c5_03_RemoveKzero{
	public static void main(String[] args) {
		System.out.println(remove("A000B000C00", 2));
	}
	public static String remove(String str, int k){
		int start = -1;
		int count = 0;
		char[] carr = str.toCharArray();
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] == '0') {
				count++;
				start = start == -1 ? i : start;
			}else{
				if (count == k) {
					while(count-- != 0){
						carr[start++] = 0;
					}
				}
				count = 0;
				start = -1;
			}
		}
		if (count == k) {
			while (count-- != 0) {
				carr[start++] = 0;
			}
		}
		return String.valueOf(carr);
	}
}