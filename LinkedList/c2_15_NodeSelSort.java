class c2_15_NodeSelSort{
	public static void main(String[] args) {
		
	}
	public static void sort(Node head){
		Node cur = head;
		Node tail = null;
		Node small = null;
		Node smallPre = null;

		while(cur != null){
			small = head;
			smallPre = getSmallPre(cur);
			if (smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small ? cur.next : cur;
			if (tail == null) {
				tail = small;
			}else{
				tail.next = small;
			}
			tail = small;
		}
	}

	public static Node getSmallPre(Node head){
		Node cur = head.next;
		Node pre = head;
		Node small = head;
		Node smallPre = null;
		while(cur != null){
			if (cur.val < small.val) {
				smallPre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}
}