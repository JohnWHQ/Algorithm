class c8_03_printMatrix{
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		printMatrix(matrix);		
	}
	public static void printMatrix(int[][] matrix){
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		int endx = matrix.length - 1;
		int endy = matrix[0].length - 1;

		boolean f = true;
		while (y1 != endy + 1) {

			int cx1 = x1;
			int cy1 = y1;
			int cx2 = x2;
			int cy2 = y2;

			if (f) {
				while (cy1 != cy2 + 1) {
					System.out.print(matrix[cx1--][cy1++] + " ");		
				}	
			}else {
				while (cy2 != cy1 - 1) {
					System.out.print(matrix[cx2++][cy2--] + " ");
				}
			}
			System.out.println();

			f = !f;

			y1 = x1 == endx ? y1 + 1 : y1;
			x1 = x1 == endx ? x1 : x1 + 1;
			
			x2 = y2 == endy ? x2 + 1 : x2;
			y2 = y2 == endy ? y2 : y2 + 1;


			// System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2);
			// break;
		}
	}
}

