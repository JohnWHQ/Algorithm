class c2_07_SmallEqualBigList{
	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(0);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(1);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;

		// Node cur = n1;
		// while(cur != null){
		// 	System.out.println(cur.value);
		// 	cur = cur.next;
		// }

		// System.out.println("after partition1:");

		// cur = partition1(n1, 3);

		// while(cur != null){
		// 	System.out.println(cur.value);
		// 	cur = cur.next;
		// }


		Node cur = n1;
		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}

		System.out.println("after partition2:");

		cur = partition2(n1, 3);

		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}		

	}
	public static Node partition1(Node head, int k){
		int index = 0;
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
			index++;
		}
		Node[] arr = new Node[index];
		cur = head;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = cur;
			cur = cur.next;
		}

		partitionNode1(arr, k);

		for (int i = 1; i < arr.length; i++) {
			arr[i - 1].next = arr[i];
		}
		arr[arr.length - 1].next = null;
		return arr[0];

	}
	public static void partitionNode1(Node[] arr, int k){
		int left = -1;
		int index = 0;
		int right = arr.length;
		while(index < right){
			if (arr[index].value < k) {
				swap(arr, ++left, index++);
			}else if (arr[index].value > k) {
				swap(arr, --right, index);
			}else {
				index++;
			}
		}
	}
	public static void swap(Node[] arr, int a, int b){
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}




	public static Node partition2(Node head, int k){
		Node lH = null;
		Node lT = null;

		Node mH = null;
		Node mT = null;

		Node rH = null;
		Node rT = null;

		Node cur = head;
		Node next = null;
		while(cur != null){

			next = cur.next;
			cur.next = null;// fucking important

			if (cur.value < k) {
				if (lH == null) {
					lH = cur;
					lT = cur;
				}else{
					lT.next = cur;
					lT = cur;
				}
			}else if (cur.value > k) {
				if (rH == null) {
					rH = cur;
					rT = cur;
				}else{
					rT.next = cur;
					rT = cur;
				}				
			}else {
				if (mH == null) {
					mH = cur;
					mT = cur;
				}else{
					mT.next = cur;
					mT = cur;
				}				
			}
			cur = next;
		}

		if (lH != null) {
			lT.next = mH;
			mT = mT == null ? lT : mT;
		}
		if (mT != null) {
			mT.next = rH;
		}

		return lH != null ? lH : mH != null ? mH : rH; 

	}
}