package stars;

/**
 * Stars
 */
public class Stars {

    public static void main(String[] args) {
        int lines = 6;
        for (int i = 1; i <= lines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int k = (lines * 3) - i; k > i; k--) {
                System.out.print(" ");
            }
            for (int l = 0; l < i; l++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
