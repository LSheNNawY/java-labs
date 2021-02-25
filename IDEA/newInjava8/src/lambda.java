import java.util.ArrayList;
import java.util.List;

public class lambda {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("ahmed");
        names.add("ali");
        names.add("mohamed");

        names.forEach(name -> System.out.println("==>" + name));
        // reference function
        names.forEach(System.out::println);
    }
}
