class c8_01_spirakOrderPrint{
	public static void main(String[] args) {
		int[][] matrix  = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}		
		};
		printSpirakOrder(matrix);

	}
	public static void printSpirakOrder(int[][] matrix) {
		int x1 = 0;
		int y1 = 0;
		int x2 = matrix.length - 1;
		int y2 = matrix[0].length - 1;
		while (x1 <= x2 && y1 <= y2) {
			if (x1 == x2) {
				for (int i = y1; i <= y2; i++) {
					System.out.print(matrix[x1][i] + " ");
				}
			}else if (y1 == y2) {
				for (int i = x1; i <= x2; i++) {
					System.out.print(matrix[i][y1] + " ");
				}
			}else{
				int x = x1;
				int y = y1;
				while(y != y2){
					System.out.print(matrix[x1][y] + " ");
					y++;
				}
				while(x != x2){
					System.out.print(matrix[x][y2] + " ");
					x++;
				}
				while(y != y1){
					System.out.print(matrix[x2][y] + " ");
					y--;
				}
				while(x != x1){
					System.out.print(matrix[x][y1] + " ");
					x--;
				}
			}
			x1++;
			y1++;
			x2--;
			y2--;
		}
	}
}