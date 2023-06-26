package corejava9.CalculatorTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorEHTask {

	 private Scanner scanner;

	    public CalculatorEHTask() {
	        scanner = new Scanner(System.in);
	    }

	    public void runCalculator() {
	        boolean shouldExit = false;

	        do {
	            int firstNumber = getInputNumber("Enter the first number: ");
	            int secondNumber = getInputNumber("Enter the second number: ");
	            char operator = getOperator();

	            try {
	                int result = performOperation(firstNumber, secondNumber, operator);
	                System.out.println("Result: "+firstNumber+ operator+ secondNumber+" = " + result);
	            } catch (ArithmeticException e) {
	                System.out.println("Error: " + e.getMessage());
	            }

	            shouldExit = !askForAnotherOperation();
	        } while (!shouldExit);

	        System.out.println("Calculator exited.");
	        scanner.close();
	    }

	    private int getInputNumber(String message) {
	        int number;

	        while (true) {
	            try {
	                System.out.print(message);
	                number = scanner.nextInt();
	                break;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter an integer.");
	                scanner.nextLine(); // Clear the input buffer
	            }
	        }

	        return number;
	    }

	    private char getOperator() {
	        char operator;

	        while (true) {
	            System.out.print("Enter the operator (+, -, *, /, %): ");
	            String input = scanner.next();

	            if (input.length() == 1) {
	                operator = input.charAt(0);
	                if (operator == '+' || operator == '-' || operator == '*' ||
	                        operator == '/' || operator == '%') {
	                    break;
	                }
	            }

	            System.out.println("Invalid operator. Please enter one of the valid operators.");
	        }

	        return operator;
	    }

	    private int performOperation(int firstNumber, int secondNumber, char operator) {
	        int result = 0;

	        switch (operator) {
	            case '+':
	                result = firstNumber + secondNumber;
	                break;
	            case '-':
	                result = firstNumber - secondNumber;
	                break;
	            case '*':
	                result = firstNumber * secondNumber;
	                break;
	            case '/':
	                result = firstNumber / secondNumber;
	                break;
	            case '%':
	                result = firstNumber % secondNumber;
	                break;
	        }

	        return result;
	    }

	    private boolean askForAnotherOperation() {
	        while (true) {
	            System.out.print("Do you want to perform another operation? (Y/N): ");
	            String input = scanner.next().toUpperCase();

	            if (input.equals("Y")) {
	                return true;
	            } else if (input.equals("N")) {
	                return false;
	            } else {
	                System.out.println("Invalid input. Please enter either 'Y' or 'N'.");
	            }
	        }
	    }
}
