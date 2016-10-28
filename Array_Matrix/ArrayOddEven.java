class ArrayOddEven{
	public static void main(String[] args) {
		int[] arr = {1,8,3,2,4,6};

		odd_even_modify(arr);

		for (int i = 0; i < arr.length ; i++ ) {
			System.out.println(i + " :" + arr[i]);
		}
		
	}
	public static void odd_even_modify(int[] arr){
		if (arr == null || arr.length < 2) {
			return ;
		}
		int even = 0;
		int odd = 1;
		int tmp ;
		while (even < arr.length - 1 || odd < arr.length -1) {
			if (arr[arr.length - 1] % 2 == 0) {
				tmp = arr[even];
				arr[even] = arr[arr.length - 1];
				arr[arr.length - 1] = tmp;
				even = even + 2;
			}else {
				tmp = arr[odd];
				arr[odd] = arr[arr.length - 1];
				arr[arr.length - 1] = tmp;
				odd = odd + 2; 
			}
		}
	}
}