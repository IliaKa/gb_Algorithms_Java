import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(start + i) % queue.length];
        }
        queue = tmp;
        start = 0;
        end = size;
        }



    public void enQueue(Item item) {
        if(size == queue.length) {
            resize( 2 * queue.length);
        }
        queue[end++] = item;
        end %= queue.length;
        size++;
    }

    public Item deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start = (start + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekFront(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item)queue[start];
    }

//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < size;  i++) {
//            s.append(queue[(start + i) % queue.length]).append(", ");
//        }
//        return s.toString();
//    }


    // task 2. вывод строки наоборот
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= size;  i++) {
            s.append(queue[(end - i) % queue.length]).append(", ");
        }
        return s.toString();
    }

}
