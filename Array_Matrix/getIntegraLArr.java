import java.util.*;
class getIntegraLArr{
	public static void main(String[] args) {
		int[] arr = {5,5,3,2,6,4,3};
		System.out.println(function1(arr));
		System.out.println(function2(arr));
 	}
	public static int function1(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = 0;
		for (int i = 0; i < arr.length ; i++ ) {
			for (int j = i ; j < arr.length ; j++ ) {
				if (isIntegrated(arr,i,j)) {
					len = Math.max(len,j - i + 1);
				}
			}
		}
		return len;
	}
	public static boolean isIntegrated(int[] arr ,int l,int r){
		int[] tmp = Arrays.copyOfRange(arr,l,r+1);
		Arrays.sort(tmp);
		for (int i = 1; i < tmp.length ; i++ ) {
			if (tmp[i] - tmp[i-1] != 1) {
				return false;
			}
		}
		return true;
	}

	public static int function2(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = 0;
		int max ;
		int min ;
        
        HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length ; i++ ) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = i; j < arr.length ; j++ ) {
				if (set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
				max = Math.max(max,arr[j]);
				min = Math.min(min,arr[j]);
				if (max - min == j - i) {
					len = Math.max(len ,j - i + 1);
				}
			}
			set.clear();
		}
		return len;
	}
}