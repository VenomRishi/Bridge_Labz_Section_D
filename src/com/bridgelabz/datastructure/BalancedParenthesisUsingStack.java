package com.bridgelabz.datastructure;

public class BalancedParenthesisUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
		String newexp = "";
		char temp;
		System.out.println("Removing numbers and special characters");
		for (int i = 0; i < exp.length(); i++) {
			temp = exp.charAt(i);
			if (!(temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp >= '0' && temp <= '9')) {
				newexp += exp.charAt(i);
			}
		}
		System.out.println(newexp);
		char[] arr = newexp.toCharArray();
		if (areParenthesisBalanced(arr)) {
			System.out.println("Expression\n" + exp);
			System.out.println("is Balanced ");
		}

		else {
			System.out.println("Expression\n" + exp);
			System.out.println("is Not Balanced ");
		}

	}

	private static boolean areParenthesisBalanced(char[] exp) {
		/* Declare an empty character stack */
		Stack stack = new Stack();

		/*
		 * Traverse the given expression to check matching parenthesis
		 */
		for (int i = 0; i < exp.length; i++) {

			/*
			 * If the exp[i] is a starting parenthesis then push it
			 */
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				stack.push(exp[i]);

			/*
			 * If exp[i] is an ending parenthesis then pop from stack and check if the
			 * popped parenthesis is a matching pair
			 */
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

				/*
				 * If we see an ending parenthesis without a pair then return false
				 */
				if (stack.isEmpty()) {
					return false;
				}

				/*
				 * Pop the top element from stack, if it is not a pair parenthesis of character
				 * then there is a mismatch. This happens for expressions like {(})
				 */
				else if (!isMatchingPair(stack.pop(), exp[i])) {
					return false;
				}
			}

		}
		/*
		 * If there is something left in expression then there is a starting parenthesis
		 * without a closing parenthesis
		 */
		if (stack.isEmpty())
			return true; /* balanced */
		else { /* not balanced */
			return false;
		}
	}

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

}
