class HeapSort{
	public static void main(String[] args) {
		int[] test = {5,9,6,8,7};
		sort(test);
		for (int i = 0; i < test.length ; i++ ) {
			System.out.println(test[i]);	
		}
	}
	public static void heapInsert(int[] arr, int x){
		int root = 0;
		int tmp = 0;
		while(x != 0){
			root = (x - 1)/2;
			if (arr[x] > arr[root]) {
				tmp = arr[root];
				arr[root] = arr[x];
				arr[x] = tmp;
				x = root;
			}else {
				break;
			}
		}
	}
	public static void heapSort(int[] arr, int i, int n){
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		int max = i;
		int tmp = 0;

		while (l < n) {
			if (arr[i] < arr[l]) {
				max = l;
			}
			if (r < n && arr[r] > arr[max]) {
				max = r;
			}
			if (i != max) {
				tmp = arr[i];
				arr[i] = arr[max];
				arr[max] = tmp;
				i = max;
			}else{
				break;
			}
			l = 2 * i + 1;
			r = 2 * i + 2;
		}

	}
	public static void sort(int[] arr){
		for (int i = 0 ; i < arr.length ; i++) {
			heapInsert(arr,i);
		}
		int tmp = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			tmp = arr[i];
			arr[i] = arr[0];
			arr[0] = tmp;
			heapSort(arr, 0, i);
		}
	}
}