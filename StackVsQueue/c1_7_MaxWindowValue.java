import java.util.*;

class c1_7_MaxWindowValue{
	public static void main(String[] args) {
		int[] arr = {4,3,5,4,3,3,6,7};
		int[] res = getMaxWinValue(arr, 3);

		for (int x : res) {
			System.out.println(x);
		}
	}
	public static int[] getMaxWinValue(int[] arr, int w){
		int[] res = new int[arr.length - w + 1];
		if (arr == null || arr.length < 1) {
			return res;
		}
		LinkedList<Integer> q = new LinkedList<Integer>();

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]){
				q.pollLast();
			}
			q.addLast(i);

			if (i - w >= q.peekFirst()) {
				q.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[q.peekFirst()];
			}
		}
		return res;
	}
}