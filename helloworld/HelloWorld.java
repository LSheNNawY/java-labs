package helloworld;

/**
 * HelloWorld
 */
public class HelloWorld {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(String.format("Hello %s", args[i]));
        }
    }
}