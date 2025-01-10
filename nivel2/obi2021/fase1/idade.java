// idade de camila

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class idade {
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int[] idades = new int[3];

      for (int i = 0; i < 3; i++) {
         idades[i] = Integer.parseInt(in.readLine().trim());
      }
      in.close();

      comp(idades, 0, 2);
      comp(idades, 1, 2);
      comp(idades, 0, 1);

      System.out.println(idades[1]);
   }
   final static void comp(int[] ar, int a, int b) {
      if (ar[b] < ar[a]) {
         int temp = ar[b];
         ar[b]    = ar[a];
         ar[a]    = temp;
      }
   }
}
