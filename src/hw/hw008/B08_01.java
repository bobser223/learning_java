package hw.hw008;



// tail <- ... <- head

class Node<T>{
    T element;
    Node<T> previous;

    public Node(T element, Node<T> previous){
        this.element = element;
        this.previous = previous;
    }

    public T getElement(){
        return element;
    }
    public Node<T> getPrevious(){
        return previous;
    }
}

class Stack<T>{
    private Node<T> head;
    private int size;

    public Stack(){
        this.head = null;
        this.size = 0;
    }

    public void push(T element){
        size++;
        this.head = new Node<>(element, this.head);
    }

    T pop(){
        if (size == 0 ||  head == null)
            return null;
        size--;
        T val = this.head.getElement();
        this.head = this.head.getPrevious();
        return val;
    }

    public T peek() {
        return (head == null) ? null : head.getElement();
    }

    public boolean isEmpty() {
        return head == null || size == 0;
    }

    public int size() {
        return size;
    }
}


public class B08_01 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        System.out.println(st.peek()); // 20
        System.out.println(st.pop());  // 20
        System.out.println(st.pop());  // 10
        System.out.println(st.pop());  // null
        System.out.println(st.size()); // 0
    }
}
