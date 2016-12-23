class test{
	public static void main(String[] args) {
		System.out.println(pingfangGen(25));
		System.out.println(pingfangGen(16));
		System.out.println(pingfangGen(9));
		System.out.println(pingfangGen(4));

		System.out.println(pingfangGen(24));
		System.out.println(pingfangGen(24));
		System.out.println(pingfangGen(24));
		System.out.println(pingfangGen(24));


		//百度上研面试 王翰琦
	}
    public static int pingfangGen(int n){  
    	if (n <= 0) {
    		return 0;
    	}
        int l = 1;  
        int r = n; 
        int m; 
        while(l <= r){  
            m = l + (r - l)/2;  
            if(m * m == n){
                return m;  
            }else if(m * m < n ){  
                l = m + 1;  

                if ((m + 1)*(m + 1) > n) {
                	return m;
                }

            }else{  
                r = m - 1;  

                if ((m - 1)*(m - 1) < n) {
                	return m;
                }                
            }  
        }  
        return 0;  
    }
}