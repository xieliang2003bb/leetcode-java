package peeking_iterator;

import java.util.Iterator;

/**
 * Created by lxie on 6/15/18.
 */
//Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private static int _value;
    private static boolean  _flag;
    private final Iterator<Integer> _iterator;


    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        _iterator = iterator;
        _flag = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!_flag) {
            _value = _iterator.next();
            _flag = true;
        }
        return _value;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!_flag) return _iterator.next();
        _flag = false;
        return _value;
    }

    @Override
    public boolean hasNext() {
        if (_flag) return true;
        if (_iterator.hasNext()) return true;
        return false;

    }
}
