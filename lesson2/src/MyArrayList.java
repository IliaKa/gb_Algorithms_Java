import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {
    private int size = 0;
    private Object[] list = new Object[1];

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    public void add(Item item) {
        if (size == list.length) {
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }

        return true;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    private void exch(int i, int j) {
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + ", ");
        }
        return s.toString();
    }


    public long selectionSort(Comparator<Item> cmp) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("selectionSort. Total time: %d ms\n", endTime);
        return endTime;
    }

    public long insertionSort(Comparator<Item> cmp) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1], cmp)) {
                    exch(j, j - 1);
                }
                else break;
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("insertionSort. Total time: %d ms\n", endTime);
        return endTime;
    }


    protected Object clone(MyArrayList<Integer> list) throws CloneNotSupportedException {
        return super.clone();
    }
}
