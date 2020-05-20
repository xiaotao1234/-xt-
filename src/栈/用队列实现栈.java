package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/12 20:24
 */
public class 用队列实现栈 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
            while (queue2.size() != 0) {
                queue1.add(queue2.poll());
            }
            Queue<Integer> queue = queue1;
            queue1 = queue2;
            queue2 = queue;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue2.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue2.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if(queue2.size()==0){
                return true;
            }
            return false;
        }
    }

}
