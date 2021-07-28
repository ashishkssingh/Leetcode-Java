package Algorithms.MinStack;

/**
 * 155. Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object. void push(val) pushes the element
 * val onto the stack. void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack. int getMin() retrieves the
 * minimum element in the stack.
 * 
 * 
 * Example 1:
 * 
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation MinStack minStack = new MinStack(); minStack.push(-2);
 * minStack.push(0); minStack.push(-3); minStack.getMin(); // return -3
 * minStack.pop(); minStack.top(); // return 0 minStack.getMin(); // return -2
 * 
 * 
 * Constraints:
 * 
 * -231 <= val <= 231 - 1 Methods pop, top and getMin operations will always be
 * called on non-empty stacks. At most 3 * 104 calls will be made to push, pop,
 * top, and getMin.
 */

class MinStack {

    class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node top;
    private Node minTop;

    /** initialize your data structure here. */
    public MinStack() {
        this.top = null;
        this.minTop = new Node(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.top = push(top, val);
        if (val <= minTop.data) {
            this.minTop = push(minTop, val);
        }
    }

    public Node push(Node top, int val) {
        Node n = new Node(val);
        if (top != null) {
            n.link = top;
        }
        return n;
    }

    public void pop() {
        if (minTop != null && top.data == minTop.data) {
            minTop = minTop.link;
            if (minTop == null)
                minTop = new Node(Integer.MAX_VALUE);
        }
        top = top.link;
    }

    public int top() {
        if (top == null)
            return -1;
        return top.data;
    }

    public int getMin() {
        if (minTop == null)
            return Integer.MAX_VALUE;
        return minTop.data;
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}