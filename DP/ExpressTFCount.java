class ExpressTFCount{
	public static void main(String[] args) {
		String str = "1^0|0|1";
		System.out.println(getExpressTFCount(str,false));
		System.out.println(getExpressTFCount("1",false));
		System.out.println(getExpressTFCount("0",false));
		System.out.println(getExpressTFCount("1",true));
		System.out.println(getExpressTFCount("0",true));
	}
	public static int getExpressTFCount(String str,boolean b){
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] carr = str.toCharArray();
		if (!check(carr)) {
			return 0;
		}
		return fuckRecursion(carr, 0, carr.length - 1, b);
	}

	public static boolean check(char[] carr){
		if ((carr.length & 1) == 0) {
			return false;
		}
		for (int i = 0; i < carr.length; i += 2) {
			if ((carr[i] != '0') && (carr[i] != '1')) {
				return false;
			}
		}
		for (int i = 1; i < carr.length; i += 2) {
			if ((carr[i]) != '&' && (carr[i] != '|') && (carr[i] != '^')) {
				return false;
			}
		}
		return true;
	}

	public static int fuckRecursion(char[] carr, int l, int r, boolean b){
		if(l == r){
			if (b) {
				return (carr[l] == '1' ? 1 : 0);
			}else {
				return (carr[l] == '0' ? 1 : 0);
			}
		}
		int res = 0;
		if (b) {
			for (int i = l + 1; i < r; i += 2) {
				switch (carr[i]) {
					case '&' : 
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, true);
						break;
					case '|' : 
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, true);
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, true);
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, false);
						break;
					case '^' :
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, false);
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, true);
						break;
				}
			}
		}else {
			for (int i = l + 1; i< r; i += 2) {
				switch (carr[i]) {
					case '&' : 
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, false);
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, true);
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, false);
						break; 
					case '|' : 
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, false);
						break;
					case '^' :
						res = res + fuckRecursion(carr, l, i - 1, true) * fuckRecursion(carr, i + 1, r, true);
						res = res + fuckRecursion(carr, l, i - 1, false) * fuckRecursion(carr, i + 1, r, false);
						break; 
				}
			}
			
		}
		return res;
	}
}