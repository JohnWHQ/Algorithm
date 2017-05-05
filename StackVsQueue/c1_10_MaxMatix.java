import java.util.*;

class c1_10_MaxMatix{
	public static void main(String[] args) {
		int[][] matrix = {{1,0,1,1},{1,1,1,1},{1,1,1,0},{1,1,1,0},{1,1,0,0},{1,1,0,0}};
		System.out.println(getMaxMatrix(matrix));
	}
	public static int getMaxMatrix(int[][] matrix){
		int[] height = new int[matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
			}
			res = Math.max(res, getMaxPerLine(height));
		}
		return res;
	}

	public static int getMaxPerLine(int[] arr){
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int index = 0;
			int l = 0;
			while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
				index = s.pop();
				l = s.isEmpty() ? -1 : s.peek();
				max = Math.max(max, (i - l - 1) * arr[index]);
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			int index = s.pop();
			int l = s.isEmpty() ? -1 : s.peek();
			max = Math.max(max, (arr.length - l - 1) * arr[index]);
		}
		return max;
	}
}