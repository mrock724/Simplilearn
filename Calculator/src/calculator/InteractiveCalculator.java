package calculator;
//package calculator.operations;
import java.util.Scanner;

import calculator.operations.AddOperation;
import calculator.operations.DivideOperation;
import calculator.operations.MultiplyOperation;
import calculator.operations.SubtractOperation;
class InteractiveCalculator {
	public static final void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the first number?");
		//System.out.println(scanner.nextInt());
		int numA = scanner.nextInt();
		scanner.nextLine();
		System.out.println("What is the second number?");
		int numB = scanner.nextInt();
		System.out.println("What is the operation?");
		scanner.nextLine();
		String operation = scanner.nextLine();
		int result = 0;
		if(operation.equals("+")) {
			AddOperation add = new AddOperation();
			add.setA(numA);
			add.setB(numB);
			result = add.getResult();
		} else if(operation.equals("-")) {
			SubtractOperation sub = new SubtractOperation();
			sub.setA(numA);
			sub.setB(numB);
			result = sub.getResult();
		} else if(operation.equals("*")) {
			MultiplyOperation mult = new MultiplyOperation();
			mult.setA(numA);
			mult.setB(numB);
			result = mult.getResult();
		} else if(operation.equals("/")) {
			DivideOperation div = new DivideOperation();
			div.setA(numA);
			div.setB(numB);
			result = div.getResult();
		} else {
			System.out.println("Operation not recognised");
		}
		System.out.println(result);
	}
}
