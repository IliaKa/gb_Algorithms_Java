public class Main {
    public static void main(String[] args) {
//        MyArrayStack<Character>  stack =  new MyArrayStack<>();
//        stack.push('a');
//        stack.push('c');
//        stack.push('d');
//        stack.push('x');
//
//        System.out.println(stack);
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack);

//        Expression expression = new Expression("[()}");
//        System.out.println(expression.checkBrackets());

        MyArrayQueue<Character> queue =  new MyArrayQueue<>();
        queue.enQueue('a');
        queue.enQueue('b');
        queue.enQueue('c');
        queue.enQueue('d');
        queue.enQueue('e');
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peekFront());
        queue.deQueue();
        System.out.println(queue.peekFront());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue.size());
        queue.deQueue();
        queue.enQueue('f');
        queue.enQueue('g');
        queue.enQueue('h');
        System.out.println(queue);
    }
}
