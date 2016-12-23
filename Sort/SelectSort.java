class SelectSort{
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
			for (int j = i; j < arr.length ; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp; 
				}
			}
		}
	}
}