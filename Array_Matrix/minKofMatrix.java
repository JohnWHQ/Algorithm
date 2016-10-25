class minKofMatrix{
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		int[] res = getKMinofMatirx_heap(arr , 5);
		for (int x : res ) {
			System.out.println(x);
		}
		
	}
	public static int[] getKMinofMatirx_heap(int[] arr , int k){
		if (arr == null || arr.length < 1 || k > arr.length) {
			return arr;
		}
		int[] res = new int[k];
 		for (int i = 0 ; i < k ; i++ ) {
			heapInsert(res,arr[i],i);
		}
		for (int i = k ; i < arr.length ; i++) {
			if (arr[i] < res[0]) {
				res[0] = arr[i];
				heapSort(res,0,k);
			}
		}
		return res;
	}
	public static void heapInsert(int[] res , int v , int i){
		res[i] = v;
		int root = 0;
		int swap_tmp ;
		while (i != 0) {
			root = (i-1)/2;
			if (res[root] < res[i]) {
				swap_tmp = res[root];
				res[root] = res[i];
				res[i] = swap_tmp;
				i = root;
			}else {
				break;
			}
		}
	}
	public static void heapSort(int[] res , int top , int n){
		int l = top * 2 + 1;
		int r = top * 2 + 2;
		int max = top;
		int swap_tmp;
		while(l < n){
			if (res[l] > res[top]) {
				max = l;
			}
			if (r < n && res[r] > res[max]) {
				max = r;
			}
			if (max != top) {
				swap_tmp = res[top];
				res[top] = res[max];
				res[max] = swap_tmp;
			}else{
				break;
			}
			top = max;
			l = top * 2 + 1;
			r = top * 2 + 2;
		}
	}
}