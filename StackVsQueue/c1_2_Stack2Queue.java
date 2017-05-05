import java.util.*;

class c1_2_Stack2Queue{
	public static Stack<Integer> pushStack = new Stack<Integer>();
	public static Stack<Integer> popStack = new Stack<Integer>();

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);

		System.out.println(pull());
		System.out.println(pull());
		System.out.println(pull());
		System.out.println(pull());
		System.out.println(pull());
	}

	public static void push(int data){
		pushStack.push(data);
	}

	public static int pull(){
		if (popStack.isEmpty()) {
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}


}