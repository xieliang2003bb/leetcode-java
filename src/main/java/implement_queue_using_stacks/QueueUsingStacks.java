package implement_queue_using_stacks;

import java.util.Stack;

/**
 * Created by lxie on 3/5/18.
 */
public class QueueUsingStacks {

    class MyQueue {

        private Stack<Integer> s = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            Stack<Integer> tmp = new Stack<>();
            while (!s.isEmpty()) {
                tmp.push(s.peek());
                s.pop();
            }
            s.push(x);
            while (!tmp.isEmpty()) {
                s.push(tmp.peek());
                tmp.pop();
            }

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return s.pop();
        }

        /** Get the top element. */
        public int peek() {
            return s.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return s.isEmpty();
        }
    }

    public static class UnitTest {

    }

}
