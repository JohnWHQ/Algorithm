class KMP
{
	public static void main(String[] args) {
		String s = "acdefbc";
		String m = "efbcd";
		System.out.println(match_normal(s,m));
		System.out.println(match_KMP(s,m));
	}
	/**
	 *普通匹配方式
	 *
	 **/
	public static int match_normal(String str ,String match){
		if (str.length() < match.length()) {
			return -1;
		}
		char[] schar_arr = str.toCharArray();
		char[] mchar_arr = match.toCharArray();
		boolean flag = true;
        	for (int i = 0; i < schar_arr.length; i++ ) {
        		if (i + mchar_arr.length > schar_arr.length) {
        			return -1;
        		}
        		for (int j = 0; j < mchar_arr.length; j++ ) {
        			if(schar_arr[i+j] != mchar_arr[j] ){
        				flag= true;
        				break;
        			}
        			flag = false;
        		}
        		if (flag == false) {
        			return  i;
        		}
        	}
        return -1;
	}

	/**
	 *KMP匹配方式
	 *
	 **/
	public static int match_KMP(String str , String match){
		if (str == null || match == null || match.length() < 1 || str.length() < match.length()) {
			return -1;
		}
		

		int i = 0; // str index
		int j = 0; // match index
        
        char[] sArr = str.toCharArray();
        char[] mArr = match.toCharArray();

        int[] nextArr = getNextArr(mArr);
		while(i < sArr.length && j < mArr.length){
			if(sArr[i] == mArr[j]){
				i++;
				j++;
			} else {
				if (nextArr[j] == -1) {
					i++;
				} else{
					j = nextArr[j];					
				}
				
			}
		}
		return j == mArr.length ? (i-j) : -1;
	}
	public static int[] getNextArr(char[] mArr) {
		if (mArr.length < 1) {
			return new int[]{-1};
		}
		int[] nextArr = new int[mArr.length];
		nextArr[0] = -1;
		nextArr[1] = 0;

		int cn = 0;
		int pos =2;

		while(pos < mArr.length) {
			if (nextArr[pos - 1] == nextArr[cn]) {
				nextArr[pos++] = ++cn;
			}else if (cn > 0) {
				cn = nextArr[cn];
			}else {
				nextArr[pos++] = 0; 
			}
		}
		return nextArr;

	}	

}