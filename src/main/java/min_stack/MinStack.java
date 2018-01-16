package min_stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> _stack = new Stack<Integer>();
    private Stack<Integer> _minStack = new Stack<Integer>();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(Integer x) {
        _stack.push(x);
        if (_minStack.empty() || x <= _minStack.peek()) _minStack.push(x);
    }

    public void pop() {
        if (!_stack.empty()) {
            if (_stack.peek() == _minStack.peek()) _minStack.pop();
            _stack.pop();
        }
    }

    public int top() {
        if (!_stack.empty()) return _stack.peek();
        return 0;
    }

    public int getMin() {
        if (!_minStack.empty()) return _minStack.peek();
        return 0;
    }

}
