
public class Main {
	
	public static int PostfixCalculator(String exp) {
		
		Stack<Integer> s = new LinkedBasedStack<Integer>();
		
		int valueCounter = 0;
		exp = deleteSpaces(exp);
		
		for(int i = 0; i < exp.length(); i++) {
			
			char character = exp.charAt(i);
			
			int check = character;	
			if(check >= 48 && check <= 57) {// check if it is between 0-9
				valueCounter++;
				
				if(i == 1) {// first two character must be a value(digit)
					if(valueCounter != 2) {
						System.out.println("Wrong postfix!");
						return -1;
					}
				}
				
				if(i == exp.length()) {// last character must be a operator but yet this still inside of digit check
					System.out.println("Wrong postfix!");
					return -1;
				}
				
				check = check - 48;
				s.push(check);
			}
			else {
				int sum = 0;
				int secondVal = s.pop();
				int firstVal = s.pop();
				switch(character) {
				case '+':
					sum = (firstVal + secondVal);
					s.push(sum);
					break;
				case '-':
					sum = (firstVal - secondVal);
					s.push(sum);
					break;
				case '*':
					sum = (firstVal * secondVal);
					s.push(sum);
					break;
				case '/':
					sum = (firstVal / secondVal);
					s.push(sum);
					break;
				default:
					break;
				}
			}
		}
		
		int res = s.pop();
		
		if(!s.isEmpty()) {
			System.out.println("Wrong postfix!");
			return -1;
		}
		
		return res;
		
	}
	
	public static String deleteSpaces(String str) {
		
		String finalStr = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				continue;
			}
			else {
				finalStr += str.charAt(i);
			}
		}
			
		return finalStr;
	}
	
	public static void main(String args[]) {
		
		String postfix = "234 *+5+";
		int sum = PostfixCalculator(postfix);
		System.out.println(sum);
		
		
	}

}
