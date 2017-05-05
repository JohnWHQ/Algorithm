import java.util.*;
class test{
	public static void main(String[] args) {
		System.out.println("test");
		// int[] a = {4,2,-5,11};
		int[] a = {2,3,6,4,5};
		List<Integer> l= f(5,-3,a);
		System.out.println(l);

	}
	public static List<Integer> f(int n,int key,int[] a){
		int index;
		int res = 0;
		List<Integer> result = new ArrayList<Integer>();

        if (key >=0) {
        	for (int i = 0; i<n ;i++ ) {
				for (int j = 1; j <= key ;j++ ) {
					index = j + i;
					index = index % n;
					res = res + a[index];
				}
				result.add(res);
				res = 0;
			}	
        }else{
        	key = key *(-1);
            for (int i = 0; i<n ;i++ ) {	
        	    for (int z=1; z<=key ; z++) {
					index = i - z;
					if(index<0){
						index = (index*(-1)) > n ? (index*(-1))%n : index;
						index = index * (-1);
					}
					index = index >= 0 ? index : (n + index);
					index = index%n;
					res = res + a[index];
				}
				result.add(res);
				res = 0;
            }
		}	
		return result;

	}
}