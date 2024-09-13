public class Example2<T> {

    private T instance;
    private Example2( ){}


    public static  <T> Example2<T> init (T initciator) {
        return new Example2<T>();
    }

    public void set(T obj) {
        instance = obj;
    }

}