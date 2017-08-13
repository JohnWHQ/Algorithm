class LeftRightFirstTake{
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 100, 4};
		int[] arr2 = {1, 100, 2};
		System.out.println(winLeftRightFirstTake(arr1));
		System.out.println(winLeftRightFirstTake(arr2));

	}
	public static int winLeftRightFirstTake(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
	}
	public static int first(int[] arr, int i, int j){
		if (i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + second(arr, i + 1,j),arr[j] + second(arr, i, j - 1));
	}
	public static int second(int[] arr, int i, int j){
		if (i == j) {
			return 0;
		}
		return Math.min(first(arr, i + 1, j), first(arr, i, j - 1));
	}
}