package datastructs.stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		assert stack.pop() == 1;
		assert stack.pop() == null;
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assert stack.peek() == 3;
		assert stack.pop() == 3;
		assert stack.peek() == 2;
		assert stack.pop() == 2;
		assert stack.pop() == 1;
		stack.push(4);
		stack.push(5);
		assert stack.pop() == 5;
		assert stack.pop() == 4;
		assert stack.pop() == null;
	}
}
