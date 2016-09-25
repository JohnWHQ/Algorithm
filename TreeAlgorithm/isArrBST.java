class isArrBST{
	public static void main(String[] args) {
		int[] test;
		check(test,0,test.length-1);
	}
	public static boolean check(int[] arr,int start ,int end){
		if (start == end) {
			return true;
		}
		int l = -1;
		int r = end;
		for (int i = 0; i < end ; i++ ) {
			if (arr[i] > arr[end]) {
				l = i;
			}else {
				r = r==end?i:r;
			}
		}
		if (l==-1 || r==end) {
			return check(arr,start,end-1);
		}
		if (l != r-1) {
			return false;
		}
		return check(arr,start,l) && check(arr,r,end-1); 

	}
}