/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn.calculator;

import operations.Operation;
import parser.NotEnoughNumbersException;
import stacks.Stack;

/**
 *
 * @author trez_
 */
public class RPNCalculator {

    /**
     * @param args the command line arguments
     */
    public Stack<Integer> calculate(Stack<Integer> numbersStack, Operation operation) throws NotEnoughNumbersException {
      if (numbersStack.size() <= 1) {
            throw new NotEnoughNumbersException("Not enough number on the stack!");
         }
        Integer number2 = numbersStack.pop();
        Integer number1 = numbersStack.pop();
        Integer result = operation.evaluate(number2, number1);
        numbersStack.push(result);
         return numbersStack;
     }
    
    
    
}
