class MinStack {
  
      private static class Node {
          int val;
          int min;
          Node(int val, int min) { this.val = val; this.min = min; }
      }

      private Deque<Node> stack;
                                                         
      public MinStack() {
          stack = new ArrayDeque<>();
      }

      public void push(int value) {
          int min = stack.isEmpty() ? value : Math.min(value, stack.peek().min);
          stack.push(new Node(value, min));
      }

      public void pop() {
          stack.pop();
      }                                                  

      public int top() {
          return stack.peek().val;
      }
                                                         
      public int getMin() {
          return stack.peek().min;
      }
  }