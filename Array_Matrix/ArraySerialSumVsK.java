import java.util.*;
class ArraySerialSumVsK{
	public static void main(String[] args) {
		int[] arr1 = {1,2,1,1,1};
		System.out.println(getUnsortArrayPSumKLen(arr1,3));

		int[] arr2 = {1,2,3,3,0,-1,1,0,6,-6,7};
		System.out.println(getUnsortArrayPNSumKLen(arr2,6));
		

	}

	// find most lens of subarray sum equals k in unsorted poisitive array
	public static int getUnsortArrayPSumKLen(int[] arr , int k){
		if (arr == null || arr.length < 1 || k < 0) {
			return 0;
		}
		int l = 0;
		int r = 0;
		int len = 0;
		int sum = arr[0];

		while (r < arr.length) {
			if (sum == k) {
				len = Math.max(len,r - l + 1);
				sum = sum - arr[l];
				l++;
			}else if (sum < k) {
				r++;
				if (r == arr.length) {
					break;
				}
				sum = sum + arr[r];			
			}else{
				sum = sum - arr[l];
				l++;
			}
		}
		return len;
	}

	public static int getUnsortArrayPNSumKLen(int[] arr , int k){
		if (arr == null || arr.length < 1) {
			return 0;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0,-1);
		int len = 0;
		int sum = 0;
		for (int i=0;i < arr.length ; i++) {
			sum = sum + arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(len , i - map.get(sum - k));
			}else{
				map.put(sum,i);
			}
		}
		return len;
	}
}