class ArrayMaxGap{
	public static void main(String[] args) {
		int[] arr = {9,3,1,10};
		System.out.println(maxGap(arr));
		
	}
	public static int maxGap(int[] arr){
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len ; i++) {
			min = Math.min(min,arr[i]);
			max = Math.max(max,arr[i]);
		}
		if (min == max) {
			return 0;
		}
		boolean[] hasNums = new boolean[len + 1];
		int[] mins = new int[len + 1];
		int[] maxs = new int[len + 1];
		int index = 0;
		for (int i = 0; i < len ; i++ ) {
			index = getBucket(arr[i],len,min,max);
			mins[index] = hasNums[index] ? Math.min(mins[index],arr[i]) : arr[i];
			maxs[index] = hasNums[index] ? Math.max(maxs[index],arr[i]) : arr[i];
			hasNums[index] = true; 
 		}
 		int res = 0;
 		int lastmax =0;
 		int i = 0;
 		while (i <= len) {
 			if (hasNums[i++]) {
 				lastmax = maxs[i-1];
 				break;
 			}
 		}
 		while(i <= len){
 			if (hasNums[i]) {
 				res = Math.max(res,mins[i] - lastmax);
 				lastmax = maxs[i];
 			}
 			i++;
 		}
 		return res;
	}
	public static int getBucket(int x,int len,int min,int max){
		return  (x - min)*len/(max - min);
	}
}