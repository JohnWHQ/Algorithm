import java.util.*;
class test{
	public static void main(String[] args){
		// char[] carr = {'A','B','Z'};
		// System.out.println((int)carr[0]);

		for (int i = 1; i <= 702; i++ ) {
			System.out.println(i + " : " +convertToTitle(i));			
		}
		// System.out.println(698 + " : " +convertToTitle(698));	
		// System.out.println(702 + " : " +convertToTitle(702));
		// System.out.println(17576 + " : " +convertToTitle(17576));	
	}
	public static String convertToTitle(int n) {
        ArrayList<Character> al = new ArrayList<Character>();
        char tmp;
        int flag = 0;
        if (n <= 26) {
        	tmp = (char)(n % 27 + 64);
        	al.add(tmp);
        }else{
	        while(n != 0){
	        	if ( n % 26 == 0) {
	        		tmp = 'Z';
	        		n = n - 26;
	        		flag = -1;
	        		al.add(tmp);
	        	}else{
	        		tmp = (char)(n % 26 + 64 + flag);
	        		al.add(tmp);
	        		flag=0;
	        	}

	            n = n / 26;   
	        }        	
        }

        char[] carr_res = new char[al.size()];
        int index = 0;
        for(int i = al.size() - 1;i >= 0; i--){
            carr_res[index++] = al.get(i);
        }
        return new String(carr_res);
        
    }
}
