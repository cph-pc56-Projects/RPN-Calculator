/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author trez_
 */
public class Multiplication implements Operation{

    @Override
    public Integer evaluate(Integer element1, Integer element2) {
        return element1 * element2;
    }
    
}
