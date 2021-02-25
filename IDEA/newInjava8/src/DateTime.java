import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class DateTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(Month.of(10));
        System.out.println("This instant => " + Instant.now());
        System.out.println("LocalTime => " + LocalTime.now());
    }
}
