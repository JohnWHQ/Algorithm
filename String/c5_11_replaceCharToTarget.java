class c5_11_replaceCharToTarget{
	public static void main(String[] args) {
		
	}
	public static void replace(char[] carr){
		if (carr == null || carr.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (len = 0; len < carr.length && carr[len] != 0; i++) {
			if (carr[len] == ' ') {
				num++;
			}
		}
		int index = len + num * 2 - 1;
		for (int i = len; i >= 0; i--) {
			if (carr[len] != ' ') {
				carr[index--] = carr[len];
			}else{
				carr[index--] = '0';
				carr[index--] = '2';
				carr[index--] = '%';
			}
		}
	}
	public static void move(char[] carr){
		if (carr == null || carr.length == 0) {
			return;
		}
		int index = carr.length - 1;
		for (int i = carr.length - 1; i >= 0; i--) {
			if (carr[i] != '*') {
				carr[index--] = carr[i];
			}
		}
		while(index >= 0){
			carr[index--] = '*';
		}
	}
}