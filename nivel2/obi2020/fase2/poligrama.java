// poligrama

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;

public class poligrama {
    static int[] base = new int[26];
    static int[] aux = new int[26];
    static int n;
    static String inputString;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine().trim());
        inputString = in.readLine();

        ArrayList<Integer> arrayList = new ArrayList<>();

        int r = (int)Math.sqrt(n);
        for (int i = 2, a = n % 2 == 0 ? 2 : 1; i <= r ; i += a) {
            if (n % i == 0) {
                arrayList.add(i); arrayList.add(n / i);
            }
        }
        arrayList.add(n);
        arrayList.sort(Comparator.naturalOrder());

        int res = 1;
        for (Integer i : arrayList) {
            if (certo(i)) {
                res = i;
            }
        }

        if (res == 1) {
            System.out.println("*");
        } else {
            System.out.println(inputString.substring(0, n / res));
        }
    }

    static boolean certo(int k) {

        for (int i = 0; i < aux.length; i++) {
            aux[i] = 0; base[i] = 0;
        }

        for (int i = 0; i < n / k; i++) {
            base[inputString.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < k; i++) {
            for (int j = i * (n / k); j < (i + 1) * (n / k); j++) {
                aux[inputString.charAt(j) - 'a']++;
                if (j == (i + 1) * (n / k) - 1) {

                    for (int p = 0; p < 26; p++) {
                        if (aux[p] != base[p]) {
                            return false;
                        }
                        aux[p] = 0;
                    }
                }
            }
        }
        return true;
    }
}