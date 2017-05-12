class c2_11_IntersectNode{
	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(9);
		Node n3 = new Node(3);
		Node n4 = new Node(7);
		Node n5 = new Node(0);

		

		Node n11 = new Node(3);
		Node n22 = new Node(6);
		Node n33 = new Node(3);
		Node n44 = new Node(2);

		

		Node c1 = new Node(11);
		Node c2 = new Node(12);
		Node c3 = new Node(13);
		Node c4 = new Node(14);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = c2;	

        n11.next = n22; n22.next = n33; n33.next = n44; n44.next = c4;	

		c1.next = c2; c2.next = c3; c3.next = c4; c4.next = c1;

		System.out.println(getIntersectNode(n1, n11).value);
		
	}

	public static Node getIntersectNode(Node head1, Node head2){
		if (head1 == null || head2 == null) {
			return null;
		}
		Node n1 = getLoopNode(head1);
		Node n2 = getLoopNode(head2);

		if (n1 == null && n2 == null) {
			return noLoop(head1, head2);
		}

		if (n1 != null && n2 != null) {
			return bothLoop(head1, n1, head2, n2);
		}

		if (n1 == null || n2 == null) {
			return null;
		}

		return null;
	}

	// judge the linkedlist have loops or not 
	public static Node getLoopNode(Node head){
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		Node first = head.next;
		Node second = head.next.next;

		while(second != first){
			if (second == null || second.next == null) {
				return null;
			}
			first = first.next;
			second = second.next.next;
		}

		first = head;
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first;
	}

	// judge both linkedlist have no loop is intersected or not

	public static Node noLoop(Node head1, Node head2){
		Node cur1 = head1;
		Node cur2 = head2;

		int len = 0;
		while(cur1.next != null){
			cur1 = cur1.next;
			len++;
		}

		while(cur2.next != null){
			cur2 = cur2.next;
			len--;
		}

		if (cur1 != cur2) {
			return null;
		}

		cur1 = len > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;

		len = Math.abs(len);

		while(len != 0){
			cur1 = cur1.next;
			len--;
		}

		while(cur1 != cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
		
		Node cur1 = null;
		Node cur2 = null;
		int len = 0;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			while(cur1.next != loop1){
				cur1 = cur1.next;
				len++;
			}
			while(cur2.next != loop2){
				cur2 = cur2.next;
				len--;
			}
			cur1 = len > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;

			len = Math.abs(len);

			while(len != 0){
				cur1 = cur1.next;
				len--;
			}

			while(cur1 != cur2){
				cur1 = cur1.next;
				cur2 = cur2.next;
			}

			return cur1;

		}else {
			Node cur = loop1.next;
			while(cur != loop1){
				if (cur == loop2) {
					return loop1; // loop2 also right
				}
				cur = cur.next;
			}
			return null;
		}
	}
}