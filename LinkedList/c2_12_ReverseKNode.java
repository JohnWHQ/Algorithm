class c2_12_ReverseKNode{
	public static void main(String[] args) {
		
	}
	public static Node reverseKNode(Node head, int k){
		if (k < 2) {
			return head;
		}
		Node cur = head;
		Node start = null;
		Node pre = null;
		Node next = null;
		int n = 1;
		while(cur != null){
			next = cur.next;
			if (n == k) {
				head = pre == null ? cur : head;
				start = pre == null ? head : pre.next;
				reveres(pre, start, cur, next);
				pre = start;
			}
			n++;
			cur = next;
		}
		return head;
	}

	public static void reveres(Node l, Node start, Node end, Node r){
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while(cur != r){
			next = cur.next;
			cur.next = pre;
			pre =cur;
			cur = next;
		}
		if (l != null) {
			l.next = end;
		}
		start.next = r;
	}

	public static Node reverce(Node pre, Node cur){
		if (cur == null) {
			return null; 
		}
		if (cur.next = null) {
			cur.next = pre;
			return  cur;
		}

		Node next = cur.next;
		cur.next = pre;
		Node res = reverce(cur, next);
		return res;
	}
}