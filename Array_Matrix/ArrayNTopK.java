class ArrayNTopK{
	public static void main(String[] args) {
		// int[] test = {10,9,8,7,6,5,4,3,2,1};
		// heapSort(test);
		// for (int i = 0; i < test.length ; i++ ) {
		// 	System.out.println(test[i]);	
		// }		

		int[][] matrix = {
			{219,405,538,845,971},
			{148,558},
			{52,99,348,691}
		};
		prinnTopK(matrix,5);	
	}


	public static void prinnTopK(int[][] matrix,int k){
		int heapSize = matrix.length;
		HeapNode[] heap = new HeapNode[heapSize];
		for (int i = 0; i < heapSize ; i++ ) {
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index] , i , index);
			heapInsert1(heap,i);
		}
		for (int i = 0; i < k ; i++ ) {
			if (heapSize == 0) {
				break;
			}
			System.out.println(heap[0].value);
			if (heap[0].index != 0) {
				heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
			}else{
				HeapNode tmp = heap[0];
				heap[0] = heap[--heapSize];
				heap[heapSize] = tmp;
			}
			heapFix1(heap,0,heapSize);
		}

	}

	public static void heapInsert1(HeapNode[] heap , int index){
		int root ;
		HeapNode tmp ;
		while(index != 0){
			root = (index - 1)/2;
			if (heap[index].value > heap[root].value) {
				tmp = heap[index];
				heap[index] = heap[root];
				heap[root] = tmp;
				index = root;
			}else{
				break;
			}
		}
	}
	public static void heapFix1(HeapNode[] heap, int index ,int heapSize){
		int l = 2 * index + 1;
		int r = 2 * index + 2;
		int max = index;
		HeapNode tmp ;
		while(l < heapSize){
			if (heap[index].value < heap[l].value) {
				max = l ;
			}
			if (r < heapSize && heap[max].value < heap[r].value) {
				max = r ;
			}
			if (index != max) {
				tmp = heap[index];
				heap[index] = heap[max];
				heap[max] = tmp;
			}else{
				break;
			}
			index = max;
			l = 2 * index + 1;
			r = 2 * index + 2;
		}
	}

	public static void heapInsert(int[] arr,int x){
		int root ;
		int tmp ;
		while (x != 0) {
			root = (x-1)/2;
			if (arr[x] > arr[root]) {
				tmp = arr[x];
				arr[x] = arr[root];
				arr[root] = tmp;
				x = root;
			}else{
				break;
			}
		}
	}
	public static void heapFix(int[] arr, int x ,int n){
		int l = 2 * x + 1;
		int r = 2 * x + 2;
		int tmp;
		int max = x;
		while(l < n){
			if (arr[x] < arr[l]) {
				max = l;
			}
			if (r < n && arr[max] < arr[r] ) {
				max = r;
			}
			if (x != max) {
				tmp = arr[x];
				arr[x] = arr[max];
				arr[max] = tmp;
			}else{
				break;
			}
			x = max;
			l = 2 * x + 1;
			r = 2 * x + 2;
		}
	}
	public static void heapSort(int[] arr){
		if (arr == null || arr.length < 0) {
			return;
		}
		for (int i = 0; i < arr.length ; i++) {
			heapInsert(arr,i);
		}
		int tmp ;
		for (int i = arr.length -1 ; i >= 0 ; i--) {
			tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapFix(arr,0,i);
		}
	}
}
class HeapNode{
	public int value;
	public int arrNum;
	public int index;
	public HeapNode(int v,int an,int i){
		value = v;
		arrNum = an;
		index = i;
	}
}