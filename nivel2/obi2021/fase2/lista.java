// lista palindroma

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class lista {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int[] lista = new int[n];

        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            lista[i] = Integer.parseInt(tk.nextToken());
        }

        int o = 0, p = lista.length - 1, contracoes = 0;
        while (o < p) {
            if (lista[o] > lista[p]) {
                lista[p - 1] += lista[p];
                contracoes++;
                p--;
            }
            else if (lista[o] < lista[p]) {
                lista[o + 1] += lista[o];
                contracoes++;
                o++;
            } 
            else {
                o++; p--;
            }
        }
        System.out.println(contracoes);

    }   
}
