/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn.calculator;

import java.util.Scanner;
import parser.NotEnoughNumbersException;
import parser.ParserException;

/**
 *
 * @author trez_
 */
public class Main {

    public static void main(String[] args) throws ParserException, NotEnoughNumbersException {
        RPNCalculator calculator = new RPNCalculator();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(calculator, scanner);

        controller.start();
    }
}
