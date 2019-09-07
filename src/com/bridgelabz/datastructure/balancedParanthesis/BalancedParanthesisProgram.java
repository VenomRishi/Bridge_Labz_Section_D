package com.bridgelabz.datastructure.balancedParanthesis;

public class BalancedParanthesisProgram {

	public static void main(String[] args) {
		String exp = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
		Stack stack=new Stack();
		for (int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i)=='(') {
				stack.push('(');
				System.out.print("Peek : "+stack.peek());
			}else if(exp.charAt(i)==')') {
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			System.out.println("Expression has balanced paranthesis");
		}else {
			System.out.println("Expression has not balanced paranthesis");
		}
	}

}
