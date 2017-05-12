class c2_01_printCommonPartOf2List{
	public static void main(String[] args) {
		
	}
	public void findCommonPart(Node node1, Node node2){
		if (node1 == null || node2 == null) {
			return;
		}
		while(node1 != null && node2 != null){
			if (node1.value > node2.value) {
				node1 = node1.next;
			}else if(node1.value < node2.value) {
				node2 = node2.next;
			}else{
				System.out.println(node1.value);
				node1 = node1.next;
				node2 = node2.next;
			}
		}
	}
}