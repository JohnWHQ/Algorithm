class rotateMatrix{
	public static void main(String[] args) {
		int[][] matrix  = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		printMatrix(matrix);

		RotateDegree90(matrix);

		printMatrix(matrix);
		
	}
	public static void RotateDegree90(int[][] matrix){
		Point pointTop = new Point(0,0);
		Point pointBottom = new Point(matrix.length - 1,matrix[0].length - 1);
		int index ;
		int tmp;
		while (pointTop.x < pointBottom.x && pointTop.y < pointBottom.y) {
			index = pointBottom.y;
			for (int i = 0;i < index ; i++) {
				tmp = matrix[pointTop.x][pointTop.y + i];
				matrix[pointTop.x][pointTop.y + i] = matrix[pointBottom.x - i ][pointTop.y];
				matrix[pointBottom.x - i][pointTop.y] = matrix[pointBottom.x][pointBottom.y - i];
				matrix[pointBottom.x][pointBottom.y - i] = matrix[pointTop.x + i][pointBottom.y];
				matrix[pointTop.x + i][pointBottom.y] = tmp;
			}
			pointTop.x++;
			pointTop.y++;
			pointBottom.x--;
			pointBottom.y--;
		}
	}
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length ; i++ ) {
			for (int j = 0; j < matrix[0].length ; j++ ) {
				System.out.print(matrix[i][j] + " " );
			}
			System.out.print("\n");
		}
	}
}