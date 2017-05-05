import java.util.*;

class c1_3_reverseStack{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

	    reverse(stack);

	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());

	}

	public static int getLastIndex(Stack<Integer> s){
		int data = s.pop();
		if (s.isEmpty()) {
			return data;
		}else{
			int res = getLastIndex(s);
			s.push(data);
			return res;
		}
	}

	public static void reverse(Stack<Integer> s){
		if (s.isEmpty()) {
			return;
		}
		int index = getLastIndex(s);
		reverse(s);
		s.push(index);
	}
}