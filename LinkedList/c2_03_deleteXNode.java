class c2_03_deleteXNode{
	public static void main(String[] args) {
		
	}
	public static Node deleteMidNode(Node head){
		if(head == null || head.next == null){
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node cur = head.next.next;
		Node pre = head;
		while(cur.next != null && cur.next.next != cur){
			cur = cur.next.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	public static Node deleteAofBNode(Node head, int a, int b){
		if (a < 1 || a > b) {
			return head;
		}
		int len = 0;
		Node cur = head;
		while(cur != null){
			len++;
			cur = cur.next;
		}
		int x = (int)Math.ceil((double)(a * len) / (double)b);
		if (x == 1) {
			return head.next;
		}
		if (x > 1) {
			cur = head;
			while(--x != 1){
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
}