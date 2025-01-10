// media ou mediana

import java.util.Scanner;

public class media {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        in.close();
        /*
        System.out.println(
            (a + b + (a - (b - a))) / 3 == a ? a - (b - a) : b + (b - a)
        );
        */
        System.out.println(2 * a - b);
    }
}
