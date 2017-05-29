class c5_17_addStringToMinSort{
	public static void main(String[] args) {
		
	}
	public String addString(String[] strs){
		if (strs == null || strs.length) {
			return "";
		}
		String res = "";
		Arrays.sort(strs, new MyComparator());
		for (int i = 0; i < strs.length; i++) {
			res = res + strs.[i];
		}
		return res;
	}

}
public class MyComparator implements Comparator<String>{
	@Override
	public int compare(String a, String b){
		return (a + b).compareTo(b + a);
	}
}