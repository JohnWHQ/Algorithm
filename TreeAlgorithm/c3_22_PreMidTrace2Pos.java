import java.util.*;

class c3_22_PreMidTrace2Pos{
	public static void main(String[] args) {
		
	}
	public static int[] getPos(int[] pre, int[] mid){
		if (pre == null || mid == null) {
			return null;
		}
		int[] pos = new int[pre.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < mid.length; i++) {
			map.put(mid[i], i);
		}
		setpos(pre, 0, pre.length - 1, mid, 0, mid.length - 1, pos, pos.length - 1, map);
		return pos
	} 

	public static int setpos(int[] pre, int pi, int pj,
		int[] mid, int mi, int mj, 
		int[] pos,int index, HashMap<Integer, Integer> map){
		if (pi > pj) {
			return index;
		}
		pos[index--] = pre[pi];
		int z = map.get(pre[pi]);
		index = setpos(pre, pi - mi + z + 1, pj, mid, z + 1, mj, pos, index, map);
		return setpos(pre, pi + 1, nj - z + pi, mid, mi, z - 1, pos, index, map);
	}
}