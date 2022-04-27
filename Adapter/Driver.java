package Adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;

public class Driver {
    /**
     * A client requires
     * @param it of type Iterator,
     *           we will use EnumerateIterator Adapter
     *           which is a implementation of Iterator Interface
     *           which will work as middle man between Enumeration and Iterator
     */
    public static void traverse(Iterator<Object> it) {
        while (it.hasNext()) {
            int val = (Integer) it.next();
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        /*
          Stack uses Enumerator
         */
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //Legacy behaviour
        Enumeration<Integer> enumeration = stack.elements();

        EnumerateIteratorAdapter enumerateIteratorAdapter = new EnumerateIteratorAdapter(enumeration);

        /*
          Instead of 'enumeration', 'enumerateIteratorAdapter' is supplied to client
          which wraps Enumeration and is of type Iterator
         */
        traverse(enumerateIteratorAdapter);
    }

}
