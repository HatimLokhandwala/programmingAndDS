import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hatim.lokhandwala on 13/05/19.
 */
public class InfixToPostfix {

	static Map<Character, Integer> precedenceMap = new HashMap<>();
	static String convert(String str){
		String output = "";
		Stack<Character> characterStack = new Stack<>();
		for(int i=0; i< str.length();i++){
			char c = str.charAt(i);
			if (isOperand(c)) output += c;
			if(c == '(') characterStack.push(c);
			if(c == ')') {
				while(characterStack.peek() != '('){
					output += characterStack.pop();
				}
				characterStack.pop();
			}
			if(isOperator(c)){
				while(!characterStack.isEmpty() && characterStack.peek() != '(' && !getPrecedence(c, characterStack.peek()) ){
					output += characterStack.pop();
				}
					characterStack.push(c);
			}
		}
		while(!characterStack.isEmpty()){
			output += characterStack.pop();
		}

		return output;
	}

	//true if precdence of a >= b
	static boolean getPrecedence(char a, char b ){
		return (precedenceMap.get(a) - precedenceMap.get(b) >= 0);
	}
	private static boolean isOperator(char c) {
		return c == '*' || c == '/' || c == '-' || c == '+';
	}

	private static boolean isOperand(char c) {
		return ((c >= 'A' && c<='Z') || (c >='a' && c<='z'));
	}

	public static void main(String[] args) {
		precedenceMap.put('/', 4);
		precedenceMap.put('*', 3);
		precedenceMap.put('+', 2);
		precedenceMap.put('-', 1);
		System.out.println(convert("A+B+C"));
		System.out.println(convert("A+(B+C)"));
		System.out.println(convert("A+(B+C*D)"));
	}
}
