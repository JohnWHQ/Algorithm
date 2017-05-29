class c5_08_CharStrDifferent{
	public static void main(String[] args) {
		
	}
	public static boolean isDifferent(String str){
		if (str == null) {
			return true;
		}
		int[] map = new int[256];
		for (int i = 0; i < str.length; i++) {
			if (map[str.charAt(i)] != 0) {
				return false;
			}
			map[str.charAt(i)]++;
		}
		return true;
	}
}