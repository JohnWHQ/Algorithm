class edgeMatrix{
	public static void main(String[] args) {
		int[][] matrix  = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		printMatrixByCircuit(matrix);
		// System.out.println(matrix.length); // line
		// System.out.println(matrix[0].length);// col
	}

	public static void printMatrixByCircuit(int[][] matrix){
		Point pLU = new Point(0,0);
		Point pRD = new Point(matrix.length-1,matrix[0].length-1);

		int tmp_x;
		int tmp_y;


			if (pLU.x == pRD.x) {
				for (int i=0; i <= pRD.y ; i++) {
					System.out.println(matrix[pLU.x][i]);
				}
			}else if (pLU.y == pRD.y) {
				for (int i=0; i <= pRD.x ; i++) {
					System.out.println(matrix[i][pLU.y]);
				}
			}else {
				while(pLU.x <= pRD.x && pLU.y <= pRD.y){
					tmp_x = pLU.x;
					tmp_y = pLU.y;
					while(tmp_y < pRD.y){
						System.out.println(matrix[pLU.x][tmp_y++]);
					}
					while(tmp_x < pRD.x){
						System.out.println(matrix[tmp_x++][pRD.y]);
					}

					while(tmp_y > pLU.y){
						System.out.println(matrix[pRD.x][tmp_y--]);
					}
					while(tmp_x > pLU.x){
						System.out.println(matrix[tmp_x--][pLU.y]);
					}
					pLU.x++;
					pLU.y++;
					pRD.x--;
					pRD.y--;
				}				
			}
		}
		
}

