import java.util.*;

class c1_5_SingleStackSort{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(4);

	    sort(stack);

	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());
	    System.out.println(stack.pop());		
	}

	public static void sort(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		if (stack.isEmpty()) {
			return;
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while(!help.isEmpty() && cur > help.peek()){
				stack.push(help.pop());
			}
			help.push(cur);
		}

		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
}