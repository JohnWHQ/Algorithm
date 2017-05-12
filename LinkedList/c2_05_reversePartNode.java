class c2_05_reversePartNode{
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = null;

		Node cur = reversePartNode(n1, 1, 5);
		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}			
	}
	public static Node reversePartNode(Node head, int from, int to){
		int len = 0;
		Node cur = head;
		Node pre = null;
		Node pos = null;
		while(cur != null){
			len++;
			pre = len == from - 1 ? cur : pre;
			pos = len == to + 1 ? cur : pos;
			cur = cur.next;
		}
		if(from < 1 || from > to || to > len){
			return head;
		}
		Node last = pre == null ? head : pre.next;
		cur = last.next;
		last.next = pos;
		Node next = null;
		while(cur != pos){
			next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
		}
		if (pre != null) {
			pre.next = last;
			return head;
		}
		return last;
	}
}