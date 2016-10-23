class rotateStrPro{
	public static void main(String[] args) {
		String str = "I am a good student!";
		System.out.println(rotateWord(str));

		String str1 = "abcdefg";
		System.out.println(rotatePatitionKToTail(str1,3));
		
	}

	public static String rotatePatitionKToTail(String str , int k){
		char[] res = str.toCharArray();

		reverse(res,0,k-1);
		reverse(res,k,res.length-1);

	    reverse(res,0,res.length-1);
	    
		return new String(res);
	}

	public static String rotateWord(String str){
		char[] sarr = str.toCharArray();
		reverse(sarr,0,sarr.length-1);
		int l = -1;
		int r = -1;

		for (int i = 0 ; i < sarr.length; i++ ) {
			if (sarr[i]!= ' ') {
				l = i==0 || sarr[i-1] == ' ' ? i : l; 
				r = i==sarr.length-1 || sarr[i+1] == ' ' ? i : r; 
			}
			if (l != -1 && r != -1) {
				reverse(sarr,l,r);
				l = -1;
				r = -1;
			}
		}
		return new String(sarr);

	}
	public static void reverse(char[] sarr , int l ,int r){
		char tmp;
		while (l < r) {
			tmp = sarr[l];
			sarr[l] = sarr[r];
			sarr[r] = tmp;
			l++;
			r--;
		}
	}
}