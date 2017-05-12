class c2_19_RelocateNode{
	public static void main(String[] args) {
		
	}
	public static void relocate(Node head){
		if (head == null || head.next == null) {
			return;
		}
		Node first = head;
		Node second = head.next;
		while (second.next != null && second.next.next != null) {
			first = first.next;
			second = second.next.next;
		}
		
		second = first.next;
		first = head;

		merge(first, second);

	}

	public static void merge(Node n1, Node n2){
		Node next = null;
		while(n1.next != null){
			next = n2.next;
			n2.next = n1.next;
			n1.next = n2;
			n1 = n2.next;
			n2 =next;
		}
		n1.next = n2;
	}
} 