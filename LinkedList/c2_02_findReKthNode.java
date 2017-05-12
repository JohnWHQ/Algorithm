class c2_02_findReKthNode{
	public static void main(String[] args) {
		
	}
	public static Node removeReKthNode(Node head, int k){
		if(head == null || k < 1){
			return head;
		}
		Node cur = head;
		while(cur != null){
			cur = cur.next;
			k--;
		}
		if (k == 0) {
			head = head.next;
		}
		if (k < 0) {
			cur = head;
			while(k != 0){
				cur = cur.next;
				k++;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
}