class minPoisOfArray{
	public static void main(String[] args) {
		int[] arr ={-1,1,2,3,4};
		System.out.println(missNum(arr));
	}
	public static int missNum(int[] arr){
		int l = 0;
		int r = arr.length;
		int tmp;
		while (l < r) {
			if (arr[l] == l + 1) {
				l++;
			}else if(arr[l] <= l || arr[l] > r || arr[arr[l] -1] == arr[l]) {
				arr[l] = arr[--r];
			}else{
				tmp = arr[arr[l] -1];
				arr[arr[l] - 1] = arr[l];
				arr[l] =tmp;
			}
		}
		return l+1;
	}
}