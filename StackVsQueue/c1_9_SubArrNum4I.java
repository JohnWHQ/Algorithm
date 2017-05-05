import java.util.*;

class c1_9_SubArrNum4I{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(getNum(arr, 1));
	}
	public static int getNum(int[] arr, int num){
		if(arr == null || arr.length < 1){
			return 0;
		}
		int res = 0;
		LinkedList<Integer> qMax = new LinkedList<Integer>();
		LinkedList<Integer> qMin = new LinkedList<Integer>();
		int l = 0;
		int r = 0;
		while(l < arr.length){
			while(r < arr.length){
				while(!qMax.isEmpty() && arr[r] >= arr[qMax.peekLast()]){
					qMax.pollLast();
				}
				qMax.addLast(r);
				while(!qMin.isEmpty() && arr[r] <= arr[qMin.peekLast()]){
					qMin.pollLast();
				}
				qMin.addLast(r);
				if (arr[qMax.peekFirst() - qMin.peekFirst()] > num) {
					break;
				}
				r++;
			}
			if (qMax.peekFirst() == l) {
				qMax.pollFirst();
			}			
			if (qMin.peekFirst() == l) {
				qMin.pollFirst();
			}
			res = res + r - l;
			System.out.println("test:" + res + " left:" + l + " right:" + r);
			l++;
		}
		return res;
	}
}