class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        int output = 0;
        for(int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (c.equals("+")) {
                int n2 = numbers.pop();
                int n1 = numbers.pop(); 
                output = (n1 + n2);
                numbers.push(output);
            } else if (c.equals("-")) {
                int n2 = numbers.pop();
                int n1 = numbers.pop(); 
                output = (n1 - n2);
                numbers.push(output);
            } else if (c.equals("/")) {
                int n2 = numbers.pop();
                int n1 = numbers.pop(); 
                output = (n1 / n2);
                numbers.push(output);
            } else if (c.equals("*")) {
                int n2 = numbers.pop();
                int n1 = numbers.pop(); 
                output = (n1 * n2);
                numbers.push(output);
            } else {
                numbers.push(Integer.parseInt(c));
            }
        }
        return numbers.peek();
    }
}
