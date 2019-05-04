import java.util.NoSuchElementException;

public class MyArrayDeque<Item> {
    private Object[] queue = new Object[1];
    private int size = 0;
    private int head = 0;
    private int tail = -1;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(head + i) % queue.length];
        }
        queue = tmp;
        head = 0;
        tail = size;
    }


    public void insertLeft(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        head = queue.length - 1;
        queue[head] = item;
        size++;
    }

    public void insertRight(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        head = queue.length-1;
        queue[head] = item;
        size++;
    }


    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[head];

        head = (head + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        size--;
        return item;
    }


    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) queue[tail];

        queue[tail] = null;
        size--;
        tail = (tail - 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size;  i++) {
            s.append(queue[(head + i) % queue.length]).append(", ");
        }
        return s.toString();
    }
}
