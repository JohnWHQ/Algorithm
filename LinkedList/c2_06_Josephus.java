class c2_06_Josephus{
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n1;

		System.out.println(getJosephus(n1, 2).value);
	}
	public static Node getJosephus(Node head, int x){
		if(head == null || head.next == head || x < 1){
			return head;
		}
		Node last = head;
		while(last.next != head){
			last = last.next;
		}
		int count = 0;
		Node cur = head;
		while(cur != last){
			if (++count == x) {
				last.next = cur.next;
				count = 0;
			}else {
				last = last.next;
			}
			cur = cur.next;
		}
		return cur;
	}
}