// zero para cancelar

import java.util.Scanner;
import java.util.Stack;

public class zero {
    public static void main(String[] args) {
        solucaoB();
    }

    static final void solucaoA() {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 0) stack.pop();
            else stack.push(x);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);

        in.close();
    } 

    static final void solucaoB() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] corrente = new int[n];

        int p = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 0) {
                p--;
            }
            else {
                corrente[p] = x;
                p++;
            }
        }
        in.close();

        int res = 0;
        for (int i = 0; i < p; i++) {
            res += corrente[i];
        }
        System.out.println(res);
    }

}