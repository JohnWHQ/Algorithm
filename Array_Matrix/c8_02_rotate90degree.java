class c8_02_rotate90degree{
	public static void main(String[] args) {
		int[][] matrix  = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}		
		};
		print(matrix);

		rotate(matrix);

		print(matrix);
	}
	public static void rotate(int[][] matrix){
		int x1 = 0;
		int y1 = 0;
		int x2 = matrix.length - 1;
		int y2 = matrix[0].length - 1;
		while (x1 < x2 && y1 < y2) {
			int n = y2 - y1;
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				tmp = matrix[x1][y1 + i];
				matrix[x1][y1 + i] = matrix[x2 - i][y1];
				matrix[x2 - i][y1] = matrix[x2][y2 - i];
				matrix[x2][y2 - i] = matrix[x1 + i][y2];
				matrix[x1 + i][y2] = tmp;
			}
			x1++;
			y1++;
			x2--;
			y2--;
		}
	}
	public static void print(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}