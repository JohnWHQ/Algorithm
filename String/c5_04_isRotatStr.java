class c5_04_isRotatStr{
	public static void main(String[] args) {
		
	}
	public boolean isRotat(String str1, String str2){
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		String str = str2 + str2;
		return str.indexOf(str1) != -1;
	}
}