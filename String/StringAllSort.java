class StringAllSort{
	public static void main(String[] args) {
		String test = "aac";
		StrAllSort(0,test);

		
	}
    public static void StrAllSort(int start ,String s,boolean ifRetri){
    	if(s == null || s.length() <=1){
    		return ;
    	}
    	if (start == s.length()) {
    		System.out.println(s);
    	}else{
	    	for (int i = start; i<=s.length()-1; i++) {
	    		if (start == i || (s.toCharArray()[start] != s.toCharArray()[i])) {
		    		s = swap(s,start,i);
		    		StrAllSort(start+1,s);
		    		s = swap(s,i,start);
	    		}
	    	}   		
    	}
    }
    public static String swap(String str,int a,int b){
    	char[] ca = str.toCharArray();
    	char tmp = ca[a];
    	ca[a] = ca[b];
    	ca[b] = tmp;
    	return new String(ca);
    }
}