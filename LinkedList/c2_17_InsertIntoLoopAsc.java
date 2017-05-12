class c2_17_InsertIntoLoopAsc{
	public static void main(String[] args) {
		
	}
	public static void insert(Node head, int num){
		Node node = new Node(num);
		if (head ==null) {
			node.next = node;
			return node;
		}

		Node pre = null;
		Node cur = head.next;
		while(cur != head){
			if (num >= pre.value && num <= cur.value) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return num > head.value ? head : node;
	}
}