class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int temp = stack.pop();
        if (mins.peek() == temp) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
