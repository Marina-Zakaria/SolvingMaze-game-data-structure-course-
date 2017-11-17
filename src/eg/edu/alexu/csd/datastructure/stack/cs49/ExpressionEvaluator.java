package eg.edu.alexu.csd.datastructure.stack.cs49;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		if (expression == null) {
			return null;
		}
		// put the expression in an array of characters
		char[] infix = new char[expression.length()];
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				infix[count++] = expression.charAt(i);
			}
		}
		// create a string for the post fix expression
		String postfix = "";
		Stack s = new Stack();
		// check on the first char in the expression must be a number
		if (!(infix[0] <= '9' && infix[0] >= '0') && !(infix[0] <= 'z' && infix[0] >= 'a')
				&& !(infix[0] <= 'Z' && infix[0] >= 'A') && !(infix[0] == '{' || infix[0] == '[' || infix[0] == '(')) {
			return null;
		}
		// check on the last char in the expression must be a number
		if (!(infix[count - 1] <= '9' && infix[count - 1] >= '0')
				&& !(infix[count - 1] <= 'z' && infix[count - 1] >= 'a')
				&& !(infix[count - 1] <= 'Z' && infix[count - 1] >= 'A')
				&& !(infix[count - 1] == '}' || infix[count - 1] == ']' || infix[count - 1] == ')')) {
			throw null;
		}
		// check on the parentheses
		for (int i = 0; i < count; i++) {
			if (infix[i] == '{' || infix[i] == '[' || infix[i] == '(') {
				s.push(infix[i]);
			} else if (infix[i] == '}' || infix[i] == ']' || infix[i] == ')') {
				if ('[' == (char) s.peek() && infix[i] != ']') {
					throw null;
				} else if ('{' == (char) s.peek() && infix[i] != '}') {
					throw null;
				} else if ('(' == (char) s.peek() && infix[i] != ')') {
					throw null;
				}
				s.pop();
			} else if (i != count - 1 && (((infix[i] <= '9' && infix[i] >= '0')
					&& (infix[i + 1] <= '9' && infix[i + 1] >= '0'))
					|| ((infix[i] <= 'z' && infix[i] >= 'a') && (infix[i + 1] <= 'z' && infix[i + 1] >= 'a'))
					|| ((infix[i] <= 'Z' && infix[i] >= 'A') && (infix[i + 1] <= 'Z' && infix[i + 1] >= 'A')))) {
				return null;
			} else if (i != count - 1 && ((!(infix[i] <= '9' && infix[i] >= '0')
					&& !(infix[i + 1] <= '9' && infix[i + 1] >= '0'))
					&& (!(infix[i] <= 'z' && infix[i] >= 'a') && !(infix[i + 1] <= 'z' && infix[i + 1] >= 'a'))
					&& (!(infix[i] <= 'Z' && infix[i] >= 'A') && !(infix[i + 1] <= 'Z' && infix[i + 1] >= 'A')))) {
				if (!(infix[i + 1] == '{' || infix[i + 1] == '[' || infix[i + 1] == '(')) {
					throw null;
				}
			}
		}
		if (!s.isEmpty()) {
			throw null;
		}
		for (int i = 0; i < count; i++) {
			char element = infix[i];
			if ((element <= '9' && element >= '0') || (element <= 'Z' && element >= 'A')
					|| (element <= 'z' && element >= 'a')) {
				postfix += infix[i] + " ";
			} else {
				if (element == '+' || element == '-') {
					if (s.isEmpty() || (char) s.peek() == '[' || (char) s.peek() == '(' || (char) s.peek() == '{') {
						s.push(element);
					} else {
						while (!(s.isEmpty() || (char) s.peek() == '[' || (char) s.peek() == '('
								|| (char) s.peek() == '{')) {
							postfix += (char) s.pop() + " ";
						}
						s.push(element);
					}
				} else if (element == '*' || element == '/') {
					if (s.isEmpty() || (char) s.peek() == '[' || (char) s.peek() == '(' || (char) s.peek() == '{'
							|| (char) s.peek() == '+' || (char) s.peek() == '-') {
						s.push(element);
					} else {
						while (!(s.isEmpty() || (char) s.peek() == '[' || (char) s.peek() == '('
								|| (char) s.peek() == '{' 
								|| (char) s.peek() == '+' || (char) s.peek() == '-')) {
							postfix += (char) s.pop() + " ";
						}
						s.push(element);
					}
				} else if (element == '[' || element == '(' || element == '{') {
					s.push(element);
				} else if (element == ']' || element == ')' || element == '}') {
					while ((char) s.peek() != '[' && (char) s.peek() 
							!= '{' && (char) s.peek() != '(') {
						postfix += (char) s.pop() + " ";
					}
					s.pop();
				}
			}
		}
		while (!s.isEmpty()) {
			postfix += (char) s.pop() + " ";
		}
		return postfix.trim();

	}

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		expression = expression.replace(" ", "");
		if (expression == null || expression == "" || expression.trim() == "") {
			throw null;
		}
		char[] postfix = new char[expression.length()];
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				if (!(expression.charAt(i) <= '9' && expression.charAt(i) >= '0') && (expression.charAt(i) != '+')
						&& (expression.charAt(i) != '-') && (expression.charAt(i) != '*')
						&& (expression.charAt(i) != '/')) {
					throw null;
				} else {
					postfix[count++] = expression.charAt(i);
				}
			}
		}
		if (count == 0) {
			throw null;
		}
		Stack s = new Stack();
		for (int j = 0; j < count; j++) {
			char element = postfix[j];
			if (element > '0' && element < '9') {
				s.push(Character.getNumericValue(element));
			} else {
				switch (element) {
				case '+':
					s.push((int) s.pop() + (int) s.pop());
					break;
				case '-':
					s.push(-(int) s.pop() + (int) s.pop());
					break;
				case '*':
					s.push((int) s.pop() * (int) s.pop());
					break;
				case '/':
					s.push(1 / (int) s.pop() * (int) s.pop());
					break;

				default:
					throw null;
				}
			}

		}
		return (int) s.pop();
	}

}
