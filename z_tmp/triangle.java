import java.util.*;
class triangle{
	public static void main(String[] args) {
		// int rowIndex = 5;
		// List<Integer> res = new ArrayList<Integer>();
  //       res.add(1);
  //       for(int i = 0; i < rowIndex; i++){
  //       	int pre = 1;
  //           for(int j = 0; j <= i + 1; j++){
  //               if(j == 0 || j == i + 1 ){
  //                      if(j == i + 1){
  //                          res.add(1);
  //                      }
  //               }else{
  //                   int tmp = pre + res.get(j);
  //                   pre = res.get(j);
  //                   res.set(j,tmp);

  //               }
  //           }
  //           System.out.println(res);
  //       }
  // System.out.println(1 % 10);
		// int[] arr = {1,1,1,2,2,2,3,3,3,3,4,4,4,5,5,5,5,6,6,6,6,6,6,7,7};
		// int i = 0;
		// int index = 1;
		// int tmp;
		// while(index < arr.length){
		// 	if (arr[i] != arr[index++] ) {
		// 		tmp = arr[i + 1];
		// 		arr[i + 1] = arr[index - 1];
		// 		arr[index - 1] = tmp;
		// 		i++;
		// 	}
		// }
		// for (int x : arr ) {
		// 	System.out.println(x);
		// }
		System.out.println(reverseBits(53));
	}
	public static long reverseBits(int n) {
        char[] carr = new char[32];
        int i =0;
        int tmp ;
        while(n != 0){
            if(n % 2 == 0){
                tmp = 0;
            }else{
                tmp = 1;
            }
            carr[i++] = (char)(tmp + '0');
            n = n >> 1;
        }
        while(i < 32){
            carr[i++] = '0';
        }
        long res = 0;
        long k = 1;
        for(int j = 31; j >= 0; j--){
            res = res + (carr[j] - '0')*k;
            k = k * 2;
        }
        // System.out.println(carr);
        return res;
    }
}