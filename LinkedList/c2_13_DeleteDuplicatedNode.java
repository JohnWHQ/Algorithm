import java.util.*;

class c2_13_DeleteDuplicatedNode{
	public static void main(String[] args) {
		
	}
	public static void delete1(Node head){
		if (head == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(cur.value);
		while(cur != null){
			if (set.contains(cur.value)) {
				pre.next = cur.next
			}else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}
	public static void delete2(Node head){
		Node cur = head;
		Node pre = null;
		Node next = null;

		while(cur != null){
			pre = cur;
			next = cur.next;
			while(next != null){
				if (pre.value == next.value) {
					pre.next = next.next;
				}else{
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}

}