class ArrayNsort{
	public static void main(String[] args) {
		int[] arr = {1,2,5,3,4};
		sort(arr);
		for (int x : arr ) {
			System.out.println(x);
		}

	}
	public static void sort(int[] arr){
		int tmp;
		for (int i = 0; i < arr.length ; i++ ) {
			while(arr[i]-1 != i){
				tmp = arr[arr[i]-1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = tmp; 
			}
		}
	}
}