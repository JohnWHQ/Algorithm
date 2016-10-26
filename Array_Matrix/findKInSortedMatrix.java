class findKInSortedMatrix{
	public static void main(String[] args) {
		int[][] matrix = {
			{0,1,2,5},
			{2,3,4,7},
			{4,4,4,8},
			{5,7,7,9}
		};
		System.out.println(find(matrix,7));
		System.out.println(find(matrix,6));
	}
	public static boolean find(int[][] matrix ,int k ){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int i = matrix[0].length - 1;
		int j = 0;
		while( i >= 0 && j <= matrix.length -1){
			if (k > matrix[j][i]) {
				j++;
			}else if( k < matrix[j][i]){
				i--;
			}else{
				return true;
			}
		}
		return false;
	}
}