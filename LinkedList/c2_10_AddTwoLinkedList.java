import java.util.*;
class c2_10_AddTwoLinkedList{
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(9);
		Node n3 = new Node(3);
		Node n4 = new Node(7);
		Node n5 = new Node(0);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;	

		Node n11 = new Node(3);
		Node n22 = new Node(6);
		Node n33 = new Node(3);
		Node n44 = new Node(2);

		n11.next = n22; n22.next = n33; n33.next = n44; n44.next = null;

		Node cur = add2(n1, n11);

		while(cur != null){
			System.out.println(cur.value);
			cur = cur.next;
		}	
        System.out.println("fuck!");

		Node cur1 = add1(n1, n11);

		while(cur1 != null){
			System.out.println(cur1.value);
			cur1 = cur1.next;
		}
	}
	public static Node add1(Node head1, Node head2){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node cur = head1;
		while(cur != null){
			s1.push(cur);
			cur = cur.next;
		}
		cur = head2;
		while(cur != null){
			s2.push(cur);
			cur = cur.next;
		}
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int flag = 0;
		Node pre = null;
		cur = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			n1 = s1.isEmpty() ?  0 : s1.pop().value;
			n2 = s2.isEmpty() ?  0 : s2.pop().value;
			n = n1 + n2 + flag;
			flag = n / 10;
			n = n % 10;
			pre = cur;
			cur = new Node(n);
			cur.next = pre;
		}
		if(flag == 1){
			pre = cur;
			cur = new Node(1);
			cur.next = pre;
		}
		return cur;
	}

	public static Node add2(Node head1, Node head2){
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int flag = 0;

		Node cur1 = reverse(head1);
		Node cur2 = reverse(head2);

		head1 = cur1;
		head2 = cur2;

		Node pre = null;
		Node cur = null;
		while(cur1 != null || cur2 != null){
			n1 = cur1 != null ? cur1.value : 0;
			n2 = cur2 != null ? cur2.value : 0;
			n = n1 + n2 + flag;
			flag = n / 10;
			n = n % 10;
			pre = cur;
			cur  = new Node(n);
			cur.next = pre;
			cur1 = cur1 != null ? cur1.next : cur1;
			cur2 = cur2 != null ? cur2.next : cur2;
		}

		if (flag == 1) {
			pre = cur;
			cur = new Node(1);
			cur.next = pre;
		}
		reverse(head1);
		reverse(head2);

		return cur;
	}

	public static Node reverse(Node head){
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}