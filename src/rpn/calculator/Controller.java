/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn.calculator;

import java.util.Scanner;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Operation;
import operations.Substraction;
import parser.NotEnoughNumbersException;
import parser.OperationParsingException;
import parser.ParserException;
import stacks.PathStack;
import stacks.Stack;

/**
 *
 * @author trez_
 */
public class Controller {

    private RPNCalculator calculator;
    private Scanner scanner;

    public Controller(RPNCalculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
    }

    public void start() throws ParserException, NotEnoughNumbersException {
        Stack<Integer> numbersStack = new PathStack<>();
        
        while (true) {
            String consoleInput = scanner.nextLine();
            if (consoleInput.equals("END")) {
                break;
            }
            String[] rawArguments = consoleInput.split(" ");
            Operation operation;
            try {
                for (String rawArgument : rawArguments) {
                    try {
                        numbersStack.push(Integer.parseInt(rawArgument));
                    } catch (NumberFormatException e) {
                        switch (rawArgument) {
                            case "*":
                                operation = new Multiplication();
                                break;
                            case "/":
                                operation = new Division();
                                break;
                            case "+":
                                operation = new Addition();
                                break;
                            case "-":
                                operation = new Substraction();
                                break;
                            default:
                                throw new OperationParsingException("Unknown operation!");
                        }
                        numbersStack = calculator.calculate(numbersStack, operation);
                    }
                }
            } catch (NotEnoughNumbersException | OperationParsingException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(numbersStack);
        }
    }

}
