package application;

public class Model {

	public float calculate(long num1, long num2, String operator) {
		switch (operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 != 0) {
				return num1 / num2;
			}else {
				return 0;
			}
		default:
			return 0;
		}
		
		
	}

}
