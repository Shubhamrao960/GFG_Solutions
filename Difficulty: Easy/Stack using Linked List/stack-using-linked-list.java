class MyStack {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    StackNode top;

    private int size=0;
    void push(int a) {
      StackNode temp=new StackNode(a);
      temp.next=top;
      top=temp;
      size++;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(size==0){
            return -1;
            
        }
        int val=top.data;
        top=top.next;
        size--;
        return val;
       
    }
}