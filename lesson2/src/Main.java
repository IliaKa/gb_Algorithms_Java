import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        long endTime = 0;
        int n = 50000;
        int m = 2;
        long totalEndTimeForSelectionSort = 0;
        long totalEndTimeForInsertionSort = 0;

        MyArrayList<Integer> list = new MyArrayList<>();
        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add((int) (Math.random() * 100000));
        }

        for (int i = 0; i < n; i++) {
            list1.add(list.get(i));
        }

        for (int i = 0; i < n; i++) {
            list2.add(list.get(i));
        }


        for (int i = 0; i < m; i++) {
            endTime = list1.selectionSort(new IntegerComparator());
            //list1.clone(list); попытался получить изначальный неотсортированный массив для следующей итерации
            totalEndTimeForSelectionSort += endTime;
        }
        System.out.printf("Average time to sort by selection after %d retry: %d ms\n", m, totalEndTimeForSelectionSort / m);

        System.out.println();


        for (int j = 0; j < m; j++) {
            endTime = list2.insertionSort(new IntegerComparator());
            //list2.clone(list); попытался получить изначальный неотсортированный массив для следующей итерации
            totalEndTimeForInsertionSort += endTime;
        }
        System.out.printf("Average time to sort by insertion after %d retry: %d ms\n", m, totalEndTimeForInsertionSort / m);
    }
}
