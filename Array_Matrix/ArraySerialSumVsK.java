import java.util.*;
class ArraySerialSumVsK{
	public static void main(String[] args) {
		int[] arr1 = {1,2,1,1,1};
		System.out.println(getUnsortArrayPSumKLen(arr1,3));

		int[] arr2 = {1,2,3,3,0,-1,1,0,6,-6,7};
		System.out.println(getUnsortArrayPNSumKLen(arr2,6));

		int[] arr3 = {3,-2,-4,0,6};
		System.out.println(getUnsortArrayPNSumSmallerKLen(arr3,-2));
		

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

	// find most lens of subarray sum equals k in unsorted poisitive  or nagtive array
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


	public static int getUnsortArrayPNSumSmallerKLen(int[] arr ,int k){
		if (arr == null || arr.length < 1) {
			return 0;
		}
		// produce MAX array
		int[] help = new int[arr.length + 1];
		help[0] = 0;
		int sum = 0;
		for (int i = 0; i < arr.length ; i++ ) {
			sum = sum + arr[i];
			help[i+1] = Math.max(sum,help[i]);
		}

		sum = 0;
		int res = 0;
		int len = 0;
		int pre = 0;
		for (int i = 0; i < arr.length ; i++ ) {
			sum = sum + arr[i];
			pre = getIndexLeft(help,sum - k);
			len = pre == -1? 0 : i - pre + 1;
			res = Math.max(res,len);
		}
		return res;
	}

	public static int getIndexLeft(int[] arr,int k){
		int r = arr.length - 1 ;
		int l = 0;
		int mid;
		int res = -1;
		while(l < r){
			mid = (l + r)/2;
			if (arr[mid] >= k) {
				res = mid;
				r = mid - 1;
			}else{
				l = mid + 1;
			}
		}
		return res;
	}









}