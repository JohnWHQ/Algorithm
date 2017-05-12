class c2_04_reverseNode{
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = null;

		Node cur = n1;
		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}
		System.out.println("after reverse:");
		cur = reverse(n1);
		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}
	}
	public static Node reverse(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node pre = null;
		Node cur = head;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next; 
		}
		return pre;
	}

	// public static Node reverseDouble(Node head){
	// 	if(head == null || head.next == null){
	// 		return head;
	// 	}
	// 	Node pre = null;
	// 	Node cur = head;
	// 	Node next = null;
	// 	while(cur != null){
	// 		next = cur.next;
	// 		cur.next = pre;
	// 		cur.last = next// hehehehehehehe
	// 		pre = cur;
	// 		cur = next; 
	// 	}
	// 	return pre;
	// }	
}