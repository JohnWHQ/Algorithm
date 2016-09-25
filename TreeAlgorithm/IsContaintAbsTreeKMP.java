import java.util.*;
class IsContaintAbsTreeKMP{
	public static void main(String[] args) {
	    ProduceTree  p1 = new ProduceTree();
	    ProduceTree  p2 = new ProduceTree();
	    TreeNode t1 = p1.head;
	    TreeNode t2 = p2.head;
	    System.out.println(IsContaint_normal(t1,t2));
	    // System.out.println(AbsoluteSubTree(t1,t2));
	    System.out.println(KMP(serializePreTree(t1),serializePreTree(t2)));
	}
	public static boolean IsContaint_normal(TreeNode t1 ,TreeNode t2){
		if (t1 == null) {
			return false; 			
		}
		return check(t1,t2) || IsContaint_normal(t1.left , t2) || IsContaint_normal(t1.right , t2);
	}
	public static boolean check(TreeNode t1 ,TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.value != t2.value) {
			return false;
		}
		return check(t1.left ,t2.left) && check(t1.right ,t2.right) ;
	}

	public static String serializePreTree(TreeNode t){
		if (t == null) {
			return "#!";
		}
		String str = t.value + "!";
		str = str + serializePreTree(t.left);
		str = str + serializePreTree(t.right);
        return str;
	}

	public static int KMP(String s , String m){
		if (s == null || m == null || m.length() < 1 || m.length() > s.length()) {
			return -1;
		}
		char[] sArr = s.toCharArray();
		char[] mArr = m.toCharArray();

		int[] next = getNextArr(mArr);

		int si = 0;
		int mi = 0;

		while (mi<mArr.length && si <sArr.length) {
			if (mArr[mi] == sArr[si]) {
				mi++;
				si++;
			}else if (next[mi] == -1) {
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == mArr.length ? (si - mi) : -1;
	}
	public static int[] getNextArr(char[] m){
		if (m.length < 1) {
			return new int[]{-1};
		}
		int[] next = new int[m.length];

		next[0] = -1;
		next[1] = 0;
		int cn = 0;
		int pos = 2;
		while(pos < m.length){
			if (next[pos-1] == next[cn]) {
				next[pos++] = ++cn;
			}else if (cn > 0) {
				cn = next[cn];
			}else{
				next[pos++] = 0;
			}
		}
		return next;

	}

}