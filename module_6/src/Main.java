import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
System.out.println(factorial(3));
//из видео пример

    List<String> list = new LinkedList<>();
     list.add("10");
    Map<String, Integer> map = new HashMap<>();
    map.entrySet();
    Set<String> set = new HashSet<>();
//Example2<User> example2 = Example2.init(new User());

//example2.set(new User("Alex", 30));
       List<User> users = getUser();
       List<User> lis = users.stream().filter(user -> user.age > 5).toList();
       lis.forEach(System.out::println);

    }
    private static List<User>  getUser(){
        return List.of(
                new User("Serg", 7),
                new User("Alex", 3),
                new User("Goga", 17)
        );

    }

    //6.2.15
public static BigInteger factorial(int value) {
    if (value < 2) {
        return BigInteger.valueOf(1);
    }
    return IntStream.rangeClosed(2, value).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
}

public static void example1(List<?> list){

}
    public static void example2(List<? extends User > list){

    }
    public static void example3(List<? super User > list){

    }

    //из видео пример
    public  static  class User {
     public String  name;
     public int age;
     User(String name,int age) {
         this.name = name;
         this.age = age;
     }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



    //6.2.14
public interface IMessage<T> {

    String getFrom();

    String getTo();

    T getContent();

}

public static class MailMessage implements IMessage<String> {

    private String from;

    private String to;

    private String content;

    public MailMessage(String from, String to, String content) {

        this.from = from;

        this.to = to;

        this.content = content;

    }

    public final String getFrom() {

        return from;

    }

    public final String getTo() {

        return to;

    }

    public final String getContent() {

        return content;

    }

}

public static class Salary implements IMessage<Integer> {

    private String from;

    private String to;

    private Integer content;

    public Salary(String from, String to, Integer content) {

        this.from = from;

        this.to = to;

        this.content = content;

    }

    public final String getFrom() {

        return from;

    }

    public final String getTo() {

        return to;

    }

    public final Integer getContent() {

        return content;

    }

}

public static class MailService<T> implements Consumer<IMessage<T>> {

    private static class MyHashMap<K, V> extends HashMap<K, V> {

        @Override

        public V get(Object key) {

            V temp = super.get(key);

            try {

                if (temp == null) temp = (V) Collections.emptyList();

            } catch (ClassCastException e) {
            }

            return temp;

        }

    }

    private Map<String, List<T>> mailBox;

    public MailService() {

        mailBox = new MyHashMap<>();

    }

    @Override

    public void accept(IMessage<T> t) {

        if (mailBox.containsKey(t.getTo())) {

            List<T> val;

            val = mailBox.get(t.getTo());

            val.add(t.getContent());

            mailBox.put(t.getTo(), val);

        } else {

            List<T> val;

            val = new LinkedList<>();

            val.add(t.getContent());

            mailBox.put(t.getTo(), val);

        }

    }

    public Map<String, List<T>> getMailBox() {

        return mailBox;

    }

}
}