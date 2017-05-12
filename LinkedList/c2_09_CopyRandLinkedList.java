import java.util.*;
class c2_09_CopyRandLinkedList{
	public static void main(String[] args) {
		
	}

	public static RNode copy1(RNode head){
		HashMap<RNode, RNode> map = new HashMap<RNode, RNode>();
		RNode cur = head;
		while(cur != null){
			map.put(cur,new RNode(cur.value));
		}
		cur = head;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}

	public static RNode copy2(RNode head){
		RNode cur = head;
		RNode next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = new RNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;

		while(cur != null) {
			cur.next.rand = cur.rand == null ? null : cur.rand.next;
			cur = cur.next.next;
		}

		// fucking split !!!!!!!!!!!
		RNode res = head.next;
		RNode copy = null;
		while(cur != next) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy = next == null ? null : next.next;
			cur = next;
		}
		return res;

	}
}