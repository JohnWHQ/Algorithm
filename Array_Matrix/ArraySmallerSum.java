class ArraySmallerSum{
	public static void main(String[] args) {
		int[] arr = {1,3,5,2,4,6};	
		int[] sumArr = {0};
		mergeSort(arr,0,arr.length - 1,sumArr);
		int sum = sumArr[0];
		System.out.println(sum);
	}

	public static void mergeSort(int[] arr,int start,int end,int[] sumArr){
		if(start < end){
			int mid = (start + end)/2;
			mergeSort(arr,start,mid,sumArr);
			mergeSort(arr,mid+1,end,sumArr);
			merge(arr,start,mid,end,sumArr);
		}
	}
	public static void merge(int[] arr ,int start ,int mid ,int end,int[] sumArr){
		int l = start;
		int r = mid + 1;
		int index = l;
		int[] tmp = new int[arr.length];
		while (l <= mid && r <= end) {
			if (arr[l] <= arr[r]) {
				sumArr[0] = sumArr[0] + arr[l] *  (end - r + 1);
				tmp[index++] = arr[l++]; 
			}else {
				tmp[index++] = arr[r++];
			}
		}
		while(l <= mid){
			tmp[index++] = arr[l++];
		}
		while(r <= end){
			tmp[index++] = arr[r++];
		}
		for (int i = start;i<=end ;i++ ) {
			arr[i] = tmp[i];
		}
	}

}