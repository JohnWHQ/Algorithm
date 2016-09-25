import java.util.*;
class bigger2Array{
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2};

 
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ;i < array.length ;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],(map.get(array[i])+1));
            }else{
                map.put(array[i],1);
            }
        }
        System.out.println(map);
        int max = Integer.MIN_VALUE;
        for(Map.Entry entry : map.entrySet()){
        	System.out.println(entry.getValue());
            if((int)entry.getValue() > max){
                max = (int)entry.getValue();
                if(max > array.length/2){
                    // return (int)entry.getKey();
                    System.out.println("hahaha:"+entry.getKey());
                }
            }
        }		
		
	}
}