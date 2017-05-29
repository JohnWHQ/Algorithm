class c5_10_rotateWordOfString{
	public static void main(String[] args) {
		
	}
	public static void rotate(String str){
		if (str == null || str.length() == 0) {
			return;
		}
		char[] carr = str.toCharArray();

		reverse(carr, 0, carr.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] != ' ') {
				l = i == 0 || carr[i - 1] == ' ' ? i : l;
				r = i == carr.length - 1 || carr[i + 1] == ' ' ? i : r;
			}
			if (l != -1 && r != -1) {
				reverse(carr, l, r);
				l = -1;
				r = -1;
			}
		}
	}
	public static void reverse(char[] carr, int l, int r){
		char tmp;
		while(l < r){
			tmp = carr[l];
			carr[l] = carr[r];
			carr[r] = tmp;
			l++;
			r--;
		}
	}
}