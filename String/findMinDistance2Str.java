class findMinDistance2Str{
	public static void main(String[] args) {
		String[] str = {"1","3","3","3","2","3","1"};
		System.out.println(find(str,"2","1"));
		
	}
	public static int find(String[] sarr,String str1 ,String str2){
		if (str1 == null || str2 == null) {
			return -1;
		}
		if (str1.equals(str2)) {
			return 0;
		}
		int si1 = -1;
		int si2 = -1;

		int min = Integer.MAX_VALUE;
		for (int i=0 ; i < sarr.length ; i++ ) {
			if (sarr[i].equals(str1)) {
				min = Math.min(min , si2 == -1 ? min : i - si2);
				si1 = i;
			}
			if (sarr[i].equals(str2)) {
				min = Math.min(min , si1 == -1 ? min : i - si1);
				si2 = i;
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}