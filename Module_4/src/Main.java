import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

//4.2.6
//        byte[] input = {1, 2, 4, 10, -4};
//        InputStream inputStream = new ByteArrayInputStream(input);
//        int result = sumOfStream(inputStream);
//        System.out.println(result);
//  // 4.3.3
//        OutputStream outputStream = new FileOutputStream("C:\\Users\\myksa\\IdeaProjects\\Module_4\\newFile.txt");
//        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
//        writer.write("Щ");
//        writer.flush();
        //4.3.2
//        while (true) {
//            int byteIn = System.in.read();
//            System.out.println(byteIn);
//        }
//4.2.7
//        InputStream stream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
//        OutputStream outputStream = new ByteArrayOutputStream();
//        print(stream, outputStream);
// 4.3.6
//        byte[] bb = new byte[] {48, 49, 50, 51}; //0, 1, 2, 3
//        ByteArrayInputStream bis = new ByteArrayInputStream(bb);
//        System.out.println(readAsString(bis, Charset.forName("ASCII")));
//4.3.7
        // create a new scanner with System Input
//        Scanner scanner = new Scanner(System.in);
//        scanner.useLocale(Locale.US);
//         double sum = 0;
//
//             while (scanner.hasNext()) {
//
//                 // check if the scanner's next token is a Double
//                 if(scanner.hasNextDouble()){
//                     sum = sum + scanner.nextDouble();
//
//                 } else {
//                     scanner.next();
//                 }
//             }
//             String str = String.format("%.6f", sum);
//             System.out.println(str);
//        scanner.close();
// 4.4..6

        byte[] intermediate = null;
        try (
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {

            oos.writeInt(3);
            oos.writeObject(new Animal("Dog"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(intermediate);
        System.out.println(Arrays.toString(animals));
    }

//4.4.6

    public static Animal[] deserializeAnimalArray(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            int size = ois.readInt();
//            if (size < 0) throw new NegativeArraySizeException(Integer.toString(size));
            Animal[] animal = new Animal[size];
            for (int i = 0; i < size; i++) {
//               if (!((Animal)ois.readObject() instanceof Animal)) {  throw  new IllegalArgumentException(); }

                animal[i] = (Animal) ois.readObject();
            }
            System.out.println(Arrays.toString(animal));
            ois.close();
            return animal;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
//        } catch (IOException e) {
//            throw new IOException(e);
//        } catch (ClassNotFoundException e) {
//            throw new ClassNotFoundException();
//        } catch (NegativeArraySizeException e){
//            throw new NegativeArraySizeException();
//        }

    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    //4.3.6
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader inp = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        int code = -1;
        while ((code = inp.read()) != -1) {
            sb.append(Character.toChars(code));
        }
        return sb.toString();
    }

    ;

    //4.2.7
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {

        while (inputStream.available() > 0) {
            byte b = (byte) inputStream.read();
            if (b % 2 == 0) {
                outputStream.write(b);
            }
        }
        outputStream.flush();
        byte[] array;
        array = outputStream.toString().getBytes();
        for (byte b : array) {
            System.out.print(b);
        }
    }

    //4.2.6
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        while (inputStream.available() > 0) {
            byte b = (byte) inputStream.read();
            sum = sum + b;

        }
        return sum;
    }
}