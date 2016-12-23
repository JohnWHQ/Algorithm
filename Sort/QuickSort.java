class QuickSort{
	public static void main(String[] args) {
		int[] arr = {3,2,5,4,1,7,6};
		sort(arr,0,arr.length-1);
		for (int x : arr ) {
			System.out.println(x);
		}			
	}
	public static void sort(int[] arr,int l, int r){
		if (l < r) {
			int x = partition(arr,l,r);
			sort(arr,l,x-1);
			sort(arr,x+1,r);
		}
	}
	public static int partition(int[] arr,int l ,int r){
		int magic = arr[l];
		while (l < r) {
			while(l < r && arr[r] >= magic){
				r--;
			}
			arr[l] = arr[r];
			while(l < r && arr[l] <= magic ){
				l++;
			}
			arr[r] = arr[l]; 
		}
		arr[l] = magic;
		return l;
	}
}