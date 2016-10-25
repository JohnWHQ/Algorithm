class zigzagMatrix{
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		printZigZagMatrix(matrix);
		
	}
	public static void printZigZagMatrix(int[][] matrix){
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,0);
		Point po = new Point(matrix.length - 1 ,matrix[0].length - 1);

		boolean flag = true ;

		while(p1.x < po.x +1){

			print(matrix,p1.x,p1.y,p2.x,p2.y,flag);

			p1.x = p1.y == po.y ? p1.x+1 : p1.x;
			p1.y = p1.y == po.y ? p1.y : p1.y+1;

// WARNING THE BIGIN FORM XY +1 !
			p2.y = p2.x == po.x ? p2.y + 1 : p2.y ;
			p2.x = p2.x == po.x ? p2.x : p2.x + 1 ;
			

			// System.out.println(p1.x+ " " + p1.y );
			// System.out.println(p2.x+ " " + p2.y );
			flag = !flag;
		}
	}
	public static void print(int[][] matrix ,int x1,int y1 ,int x2 ,int y2,boolean flag){
		// int i = 0;
		if (flag) {
			while(x2 >= x1 || y2 <= y1){
				System.out.println(matrix[x2--][y2++]);
			}
		}else {
			while(x1 <= x2 || y1 >= y2){
				System.out.println(matrix[x1++][y1--]);
			}
		}
		// System.out.println(i++);
	}
}