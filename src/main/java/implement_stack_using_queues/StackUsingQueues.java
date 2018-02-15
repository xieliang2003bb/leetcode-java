package implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 2/15/18.
 */
public class StackUsingQueues {

    class MyStack {

        private Queue<Integer> q = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> tmp = new LinkedList<>();
            while (!q.isEmpty()) {
                tmp.add(q.peek());
                q.remove();
            }
            q.add(x);
            while (!tmp.isEmpty()) {
                q.add(tmp.peek());
                tmp.remove();
            }

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.remove();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    public static class UnitTest {

    }
}
