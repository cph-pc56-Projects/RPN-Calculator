/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author trez_
 */
public class GenericPath<T> implements Path<T> {

    private T first;
    private Path<T> rest;

    public GenericPath(T first, Path<T> rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public Path<T> getRest() {
        return rest;
    }

    @Override
    public String toString() {
        if (rest == null) {
            return "> " + first;
        }
        return rest.toString() + "\n" + "> " + first;
    }
}
