class HeapSort{
	public static void main(String[] args) {
		// int[] test = {10,9,8,7,6,5,4,3,2,1};
		int[] test = {5,9,6,8,7};
		sort(test);
		for (int i = 0; i < test.length ; i++ ) {
			System.out.println(test[i]);	
		}	
	}
	public static void heapInsert(int[] arr ,int x){
		int root = 0;
		int swaptmp ;
		while (x != 0) {
			root = (x - 1)/2;
			if (arr[x] < arr[root]) {
				swaptmp = arr[x];
				arr[x] = arr[root];
				arr[root] = swaptmp;
				x = root;
			}else {
				break;
			}
		}
	}
	public static void heapSort(int[] arr , int x ,int n){
		int l = 2*x + 1;
		int r = 2*x + 2;

		int min = x;
		int swaptmp ;

		while(l < n){
			if (arr[l] < arr[x]) {
				min = l;
			}
			if (r < n && arr[r] < arr[min] ) {
				min = r;
			}
			if (x != min) {
				swaptmp = arr[x];
				arr[x] = arr[min];
				arr[min] = swaptmp;
			}else{
				break;
			}
			x = min;
			l = 2 * x + 1;
			r = 2 * x + 2;
		}
	}
	public static void sort(int[] arr){
		for (int i = 0 ; i < arr.length ; i++) {
			heapInsert(arr,i);
		}

		// for (int i = 0; i < arr.length ; i++ ) {
		// 	System.out.println(arr[i]);	
		// }	

		int tmp ;
		for (int i = arr.length - 1  ; i > 0  ; i--) {
			tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapSort(arr,0,i);
		}		


	}
}