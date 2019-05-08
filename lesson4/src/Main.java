public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println(linkedList.size());
        System.out.println(linkedList);

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        System.out.println(linkedList.get(1));
        linkedList.set(1, 4);
        System.out.println(linkedList.get(1));

        linkedList.addLast(6);
        linkedList.add(2, 7);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println(linkedList.size());

        for (Integer item:
                linkedList) {
            System.out.printf("%d, ", item);
        }
    }
}