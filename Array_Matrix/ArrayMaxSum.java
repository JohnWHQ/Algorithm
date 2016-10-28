class ArrayMaxSum{
	public static void main(String[] args) {
		int[] arr = {1,-2,3,5,-2,6,-1};
		System.out.println(getMaxOfArray(arr));
	}
	public static int getMaxOfArray(int[] arr){
		int cur = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length ; i++ ) {
			cur = cur + arr[i];
			max = Math.max(cur,max);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}
}