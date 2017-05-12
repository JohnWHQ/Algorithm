class c2_16_DeleteNodeFuck{
	public static void main(String[] args) {
		
	}
	public static void delete(Node node){
		if (node.next = null) {
			return;
		}
		Node next = node.next;
		node.value = next.value;
		node.next = next.next;
	}
}