class ArrayMaxProduct{
	public static void main(String[] args) {
		double[] arr = {-2.5,4,0,3,0.5,8,1};
		System.out.println(getMaxProduct(arr));
	}
	public static double getMaxProduct(double[] arr){
		if (arr == null || arr.length < 1) {
			return 0;
		}
		double min = arr[0];
		double max = arr[0];
		double res = arr[0];
		double tmp_max ;
		double tmp_min ;
		for (int i = 1; i < arr.length ; i++ ) {
			tmp_min = min * arr[i];
			tmp_max = max * arr[i];
			max  = Math.max(Math.max(tmp_max,tmp_min),arr[i]);
			min  = Math.min(Math.min(tmp_max,tmp_min),arr[i]);
			res =Math.max(res,max);
		}
		return res;
	}
}