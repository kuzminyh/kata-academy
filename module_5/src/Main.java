import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//import static sun.security.krb5.Confounder.intValue;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        //5.2.12
//        static Collection<?> collection = new Collection<Object>();
//        Object object = new Object();
//        collection.add(object);
//        collection.contains(object);
//        collection.addAll(Arrays.asList(object));
//        collection.clear();
//        collection.remove(object);
//        collection.toArray();
//        collection.iterator();
//        collection.size();
        // 5 1 14
//        DynamicArray<Integer> array = new DynamicArray<>();
//        array.add(1);
//        array.add(2);
//        array.add(3);
//        array.add(4);
//        array.add(5);
//        array.add(6);
//        array.add(7);
//        array.add(8);
//        array.add(9);
//        array.add(10);
//        array.remove(7);
//        array.remove(7);
//        array.remove(7);
//        array.add(0);
//        array.add(1);
//        array.add(2);
//        array.add(3);
//        array.add(4);
//
//        for (int i = 0; i < array.size(); i++) {
//            System.out.print(array.get(i) + " ");
//        }
//
//5.2.13
//        Set<Integer> s1 = new HashSet<>();
//        s1.add(1);
//        s1.add(2);
//        s1.add(3);
//
//        HashSet<Integer> s2 = new HashSet<>();
//        s2.add(0);
//        s2.add(1);
//        s2.add(2);
//
//        Set<Integer> result = symmetricDifference(s1,s2);
//        System.out.println(result);
        //5.2.14
//        Reader reader = new StringReader("Алексей 3000\n" +
//                "Дмитрий 9000\n" +
//                "Антон 3000\n" +
//                "Алексей 7000\n" +
//                "Антон 8000");
//        getSalesMap(reader);
//5.2.15

//        Scanner scanner = new Scanner(System.in);
//        int n = 0;
//        ArrayDeque<Integer> arrayDeque= new ArrayDeque<>();
//
//        while (scanner.hasNextInt()){
//            if (n % 2 != 0){
//                arrayDeque.add(scanner.nextInt());
//            }
//            else scanner.next();
//            n++;
//        }
//        Iterator iterator = arrayDeque.descendingIterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next()+" ");
//        }
//6.2.13
  ///!!!добавить throw exception в заголовок метода
        HashMap < String, Integer > hsh = new HashMap < > ();
        (new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) // для проверки надо StandardCharsets.UTF_8
                .lines()
                .flatMap(x -> Stream.of(x.split("[\\p{Punct}\\s]+")))
                .map(y -> y.toLowerCase())
                .forEach(w -> {
                    if (hsh.containsKey(w)) {
                        hsh.put(w, hsh.get(w) + 1);
                    } else {
                        hsh.put(w, 1);
                    }
                });

        hsh.entrySet()
                .stream()
                .sorted((x1, x2) -> {
                    if (x1.getValue() == x2.getValue()) {
                        return x1.getKey().compareTo(x2.getKey());
                    } else {
                        return x2.getValue().compareTo(x1.getValue());
                    }
                })
                .limit(10)
                .forEach(z -> System.out.println(z.getKey()));
    }

//List
    //6.2.13

    //6.2.12
public <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {
    List<T> list = stream.sorted(order).collect(Collectors.toList());
    if (list.isEmpty()) {
        minMaxConsumer.accept(null, null);
    } else {
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }
}
//6.2.11
public static IntStream pseudoRandomStream(int seed) {
    return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
}
    //6.1.10
public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {
    return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
}
    //6.1.9
    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;

    }
    interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }
//6.1.8
//public UnaryOperator<Integer> sqrt() {
//    return  x -> x * x;
//}
//5.2.14
 //    public static Map<String, Long> getSalesMap(Reader reader) {
 //    HashMap<String, Long> hashMap = new HashMap<>();
//
//      Scanner scan = new Scanner(reader);
//
//        while (scan.hasNext()) {
//            hashMap.merge(scan.next(), scan.nextLong(), Long::sum);
//        }
//        return hashMap;
//}
//5.2.13
//public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
//     HashSet<T> setHash1 = new HashSet<T>(set1);
//     HashSet<T> setHash2 = new HashSet<T>(set2);
//     HashSet<T> setHash3 = new HashSet<T>(set1);
//     HashSet<T> setHash4 = new HashSet<T>(set2);
//     setHash3.removeAll(setHash2);
//     setHash4.removeAll(setHash1);
//     setHash3.addAll(setHash4);
//     Set<T> setHash31 = setHash3;
//    return setHash31;
//}
    // 5 1 14
//    public static class DynamicArray<T> {
//            private T[] arr;
//            private  int size;
//
//
//        public DynamicArray(){
//            arr = (T[]) new Object[3];
//            size = 0;
//
//        }
//       public T get(int index){
//            isIndexExist(index);
//            return arr[index];
//       }
//
//       public int size() {
//            return size;
//       }
//
//       public void add(T el) {
//            if(size == arr.length) {
//                arr = increaseCapacity();
//            }
//           arr[size] = el;
//            size++;
//        }
//
//        private T[] increaseCapacity(){
//            T [] temp = (T[]) new Object [(arr.length * 2)];  //создаем новый массив большего размера
//            System.arraycopy(arr, 0, temp, 0, arr.length);  //копируем в новый массив элементы из старого массива
//            return temp;
//        }
//
//        private int isIndexExist(int index){
//            if (index >= size || index < 0){
//                throw new ArrayIndexOutOfBoundsException();
//            }
//            return index;
//        }
//
//        public void remove(int index){
//            isIndexExist(index);
//            T[] temp = arr;
//            arr =  (T[]) new Object [(temp.length - 1)];
//            T value = temp[index];
//            System.arraycopy(temp, 0, arr, 0, index);
//            System.arraycopy(temp, index + 1, arr, index, temp.length - index - 1);
//            size--;
//        }
//
//    }

    // 5 1 12
//    public static class Pair<T, V> {
//      private   T ob1;
//      private   V ob2;
//
//
//
//      public Pair(T o, V c) {
//            ob1 = o;
//            ob2 = c;
//        }
//
//      public T getFirst() {
//           return ob1;
//       }
//
//      public V getSecond() {
//           return ob2;
//       }
//
//        public static <T, V> Pair<T, V> of(T o, V c) {
//            return new Pair<>(o , c) ;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) { return true ;}
//            if (o == null || getClass() != o.getClass()) {return false;}
//            Pair<?, ?> pair = (Pair<?, ?>) o;
//            return Objects.equals(ob1, pair.ob1) && Objects.equals(ob2, pair.ob2);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(ob1, ob2);
//        }
//    }

    // 5.1.11
//    class Box<T> {
//        private T object;
//    }

    // 5.1.12
//    public static class Box <T> {
//        private T object;
//        public static <T> Box <T> getBox() {
//            return new <T> Box <T>();
//        }
//    }
}
