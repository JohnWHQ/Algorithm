import java.util.*;
class c2_08_isPalindrome{
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(3);
		Node n5 = new Node(2);
		Node n6 = new Node(1);

		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = null;

		System.out.println(isPalindrome1(n1));
		System.out.println(isPalindrome2(n1));
		System.out.println(isPalindrome3(n1));		
	}
	public static boolean isPalindrome1(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null){
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while(!stack.isEmpty()){
			if (stack.pop().value != cur.value) {
				return false;
			}
			cur = cur.next;
		}

		return true;
	}

	public static boolean isPalindrome2(Node head){
		if(head == null || head.next == null){
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		Node index = head.next;
		Node cur = head;

		// fuck to rest the right 1-2-3 only 3 ; 1,2,3,2,1 only 2-1
		while(cur.next != null && cur.next.next != null) {
			index = index.next;
			cur = cur.next.next;
		}
		while(index != null) {
			stack.push(index);
			index = index.next;
		}
		cur = head;

		while(!stack.isEmpty()) {
			if(cur.value != stack.pop().value){
				return false;
			}
			cur = cur.next;
		}

		return true;
	}

	public static boolean isPalindrome3(Node head){
		if (head == null || head.next == null) {
			return true;
		}

		Node n1 = head;
		Node n2 = head;

		// fuck to rest the left 1-2-3 only 1 ; 1,2,3,2,1 only 3-2-1
		while(n2.next != null && n2.next.next != null){
			n1 = n1.next;
			n2 = n2.next.next;
		}

		Node cur = n1.next;
		n1.next = null;
		Node pre = n1;
		Node next = null;

		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next; 
		}
 
 		Node tail = pre;

 		n1 = head;
 		n2 = pre;
 		boolean res = true;
 		while(n1 != null && n2 != null){
 			if(n1.value != n2.value){
 				res = false;
 				break;
 			}
 			n1 = n1.next;
 			n2 = n2.next;
 		}

 		pre = null;
 		next = null;
 		while(tail != null) {
 			next = tail.next;
 			tail.next = pre;
 			pre = tail; 
 			tail = next;
 		}
 		return res;
	}
}