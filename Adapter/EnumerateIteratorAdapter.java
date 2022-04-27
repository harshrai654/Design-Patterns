package Adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

public class EnumerateIteratorAdapter implements Iterator<Object> {
    /**
     * The pattern looks similar to Decorator pattern as
     * this pattern also wraps object of another type but the behaviours are added
     * according to Target Interface abstract methods which are most of the time delegated to Adaptee Interface
     */

    private final Enumeration<?> enumerate;

    public EnumerateIteratorAdapter(Enumeration<?> enumerate) {
        this.enumerate = enumerate;
    }

    @Override
    public boolean hasNext() {
        /*
          Delegating implmentation of Iterator methods to Enumerations
         */
        return enumerate.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumerate.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This operation is not supported with EnumerateIterator Adapter");
    }

    @Override
    public void forEachRemaining(Consumer<? super Object> action) {
        throw new UnsupportedOperationException("This operation is not supported with EnumerateIterator Adapter");
    }
}
