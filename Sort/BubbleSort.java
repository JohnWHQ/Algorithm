class BubbleSort{
	public static void main(String[] args) {
		int[] arr = {3,2,5,4,1,7,6};
		sort(arr);
		for (int x : arr ) {
			System.out.println(x);
		}
	}
	public static void sort(int[] arr){
		int max ;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					max = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = max;
				}
			}
		}
	}
}