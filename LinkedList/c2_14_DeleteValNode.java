class c2_14_DeleteValNode{
	public static void main(String[] args) {
		
	}
	public static Node delete1(Node head, int num){
		Stack<Node> s = new Stack<Node>();
		Node cur = head;
		while(cur != null){
			if (cur.value != num) {
				s.push(cur);
			}
			cur = cur.next;
		}

		while(!s.isEmpty()){
			s.peek().next = cur;
			cur = s.pop();
		}
		return cur;
	}

	public static Node delete2(Node head, int num){
		while(head != num){
			if (head.value != num) {
				break;
			}
			head = head.next; 
		}
		Node pre = head;
		Node cur = head;
		while(cur != null){
			if (pre.value == cur.value) {
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}