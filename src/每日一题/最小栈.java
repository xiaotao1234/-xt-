package 每日一题;

import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/12 8:42
 */
public class 最小栈 {

    public static void main(String[] args) {
        最小栈 s = new 最小栈();
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }

    static class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.size() == 0 || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (stack1.pop().equals(stack2.peek())) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
