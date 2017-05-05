import java.util.*;
class c1_1_getMinStack{
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Stack<Integer> minStack = new Stack<Integer>();

	public static void main(String[] args) {
		push(7);
		push(9);
		push(5);
		push(3);
		push(6);

		System.out.println(getMin());

		pop();
		pop();

		System.out.println(getMin());


	}
	public static void push(int data){
		stack.push(data);
		if (minStack.isEmpty()) {
			minStack.push(data);
		}else {
			if (data < minStack.peek()) {
				minStack.push(data);
			}else{
				minStack.push(minStack.peek());
			}
		}
	}

	public static int pop(){
		minStack.pop();
		return stack.pop();
	}

	public static int getMin(){
		return minStack.peek();
	}
}