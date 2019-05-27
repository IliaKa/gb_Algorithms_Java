public class Main {
    public static void main(String[] args) {
        MyChainingHashMap<Character, Integer> hashMap = new MyChainingHashMap<>();
        hashMap.put('a', 1);
        hashMap.put('z', 2);
        hashMap.put('s', 3);
        hashMap.put('d', 4);
        hashMap.put('f', 5);
        hashMap.put('g', 6);
        hashMap.put('h', 7);

        System.out.println(hashMap.get('z'));
        System.out.println(hashMap.contains('f'));
        System.out.println(hashMap.isEmpty());

    }
}
