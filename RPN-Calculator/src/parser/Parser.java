/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.List;
import operations.Addition;
import operations.Division;
import operations.Multiplication;
import operations.Operation;
import operations.Substraction;
import stacks.Stack;

/**
 *
 * @author trez_
 */
public class Parser {
    
    public Stack<Integer> parseNumbers(Stack<Integer> numbers, String[] rawArguments) {
        for (String rawConsoleArgument : rawArguments) {
            try {
                Integer number = Integer.parseInt(rawConsoleArgument);
                numbers.push(number);
            } catch (NumberFormatException e) {
                break;
            }
        }
        return numbers;
    }
    
    
    public List<Operation> parseOperations (List<Operation> operations, int countOfAddedNumbers, String[] rawConsoleArguments) throws ParserException {
        for (int i = countOfAddedNumbers; i < rawConsoleArguments.length; i++) {
            switch (rawConsoleArguments[i]) {
                case "*":
                    operations.add(new Multiplication());
                    break;
                case "/":
                    operations.add(new Division());
                    break;
                case "+":
                    operations.add(new Addition());
                    break;
                case "-":
                    operations.add(new Substraction());
                    break;
                default: 
                    throw new ParserException("Unknown Operation!!");
            }
        }
        return operations;
    }
}
