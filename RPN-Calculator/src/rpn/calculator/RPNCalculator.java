/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn.calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import operations.Operation;
import parser.Parser;
import parser.ParserException;
import stacks.ArrayStack;
import stacks.Stack;

/**
 *
 * @author trez_
 */
public class RPNCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserException {
        
        System.out.println("Reverse Polish Notation Calculator Initialised: Start calculating!");
        System.out.println("Type \'stop\" to shut off the RPN");
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        Stack<Integer> numbersStack = new ArrayStack<>();
        List<Operation> operations = new ArrayList<>();
        
        while(true){
            String consoleInput = in.nextLine();
            if(consoleInput.equals("stop")) {
                System.out.println("Calculator Stopped");
                break;
            }
            String[] rawArguments = consoleInput.split(" ");
            int oldSize = numbersStack.size();
            numbersStack = parser.parseNumbers(numbersStack, rawArguments);
            int countOfAddedNumbers = numbersStack.size() - oldSize;
            operations = parser.parseOperations(operations, countOfAddedNumbers, rawArguments);
            if(!operations.isEmpty()) {
                try {
                    calculate(numbersStack, operations);
                } catch (Exception e) {
                    operations.remove(operations.size() -1);
                }
            }
            System.out.println(numbersStack);
        }
    }
    
    
    private static void calculate(Stack<Integer> numbersStack, List<Operation> operations) throws Exception {
        Iterator<Operation> iterator = operations.iterator();
        while (iterator.hasNext()) {
            if(numbersStack.size() <= 1) {
                throw new Exception("No more numbers in stack!");
            }
            Integer number1 = numbersStack.pop();
            Integer number2 = numbersStack.pop();
            Operation operation = iterator.next();
            numbersStack.push(operation.evaluate(number1, number2));
            iterator.remove();
        }
    }
}
