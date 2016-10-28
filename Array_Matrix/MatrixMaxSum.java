class MatrixMaxSum{
	public static void main(String[] args) {
		int[][] matrix = {
			{-90,48,78},
			{64,-40,64},
			{-81,-7,66}
		};
		System.out.println(getMaxOfMatrix(matrix));
	}
	public static int getMaxOfMatrix(int[][] matrix){
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return 0;
		}
		int cur = 0;
		int max = Integer.MIN_VALUE;
		int[] tmp ;
		for (int i = 0; i < matrix.length ; i++ ) {
			tmp = new int[matrix[0].length];
			for (int j = i; j < matrix.length ; j++ ) {
				cur = 0;
				for (int k = 0; k < matrix[0].length ; k++ ) {
					tmp[k] = tmp[k] + matrix[j][k];
					cur = cur + tmp[k];
					max = Math.max(max,cur);
					cur = cur < 0 ? 0 : cur;
				}
			}
		}
		return max;
	}
}