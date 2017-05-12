class c8_23_ArrayPartition{
	public static void main(String[] args) {

		int[] arr = {1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
		for (int x : arr ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		partionLeftNoRepeatAndAsc(arr);
		for (int x : arr ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		System.out.println("__________________________");


		int[] arr1 = {0,1,2,0,1,2,0,1,2};
		for (int x : arr1 ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		partitionLeftMidRight(arr1);
		for (int x : arr1 ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		System.out.println("__________________________");


		int[] arr2 = {9,0,4,5,1};
		for (int x : arr2 ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		partitionSmallEqualBig(arr2, 3);
		for (int x : arr2 ) {
			System.out.print(x + "  ");
		}
		System.out.println();
		System.out.println("__________________________");		

	}

	public static void partionLeftNoRepeatAndAsc(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		int u = 0;
		int i = 1;
		while (i != arr.length) {
			if (arr[i++] != arr[u]) {
				swap(arr, ++u, i - 1);
			}
		}
	}
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void partitionLeftMidRight(int[] arr){
		int left = -1;
		int i = 0;
		int right = arr.length;
		while(i < right){
			if(arr[i] == 0){
				swap(arr, ++left, i++);
			}else if (arr[i] == 2) {
				swap(arr, --right, i);
			}else{
				i++;
			}
		}
	}

	public static void partitionSmallEqualBig(int[] arr, int k){
		int left = -1;
		int i = 0;
		int right = arr.length;
		while(i < right){
			if(arr[i] < k){
				swap(arr, ++left, i++);
			}else if (arr[i] > k) {
				swap(arr, --right, i);
			}else{
				i++;
			}
		}
	}	
}