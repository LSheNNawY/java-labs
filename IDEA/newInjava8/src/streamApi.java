import java.util.stream.IntStream;

public class streamApi {
    public static void main(String[] args) {
        int[] numbers = {22, 70, 15, 8, 19, 8, 80, 9};

        System.out.println("Printing numbers sorted: ");
        IntStream.of(numbers).sorted().forEach(value -> System.out.print(value + " => "));
    }
}
