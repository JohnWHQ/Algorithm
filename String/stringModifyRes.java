class stringModifyRes{
	public static void main(String[] args) {
		String s = "a b  c    ";
		System.out.println(resCopy1(s));

		String s1 = "a*b**c*d**e**";
		System.out.println(resCopy2(s1));
	}
	public static String resCopy1(String str){
		char[] sarr = str.toCharArray();
		int num = 0;
		for (int i = 0; i < sarr.length; i++ ) {
			if (sarr[i]==' ') {
				num++;
			}
		}
		int res_len = sarr.length + 2*num;
		char[] res = new char[res_len];

		for (int i = sarr.length - 1;i >= 0 ; i-- ) {
			if (sarr[i]!=' ') {
				res[--res_len] = sarr[i];
			}else {
				res[--res_len] = '0';
				res[--res_len] = '2';
				res[--res_len] = '%';
			}
		}
		return new String(res);
	}
	public static String resCopy2(String str){
		char[] res = str.toCharArray();
		int j = res.length-1;
		for (int i = res.length - 1; i >=0 ; i-- ) {
			if (res[i]!= '*') {
				res[j--] = res[i];
			}
		}
		while(j>=0){
			res[j--] = '*';
		}
		return new String(res);
	}
}