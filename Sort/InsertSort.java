class InsertSort{
	public static void main(String[] args) {
		int[] arr = {3,2,5,4,1,7,6};
		sort(arr);
		for (int x : arr ) {
			System.out.println(x);
		}			
	}
	public static void sort(int[] arr){
		int tmp;
		for (int i = 0; i < arr.length ; i++) {
			for (int j = i; j >0 ;j-- ) {
				if(arr[j] < arr[j - 1]){
					tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
}