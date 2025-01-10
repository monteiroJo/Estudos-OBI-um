// calculo rapido

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class calculo {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int[] todasSomasDigitos = new int[10001];
        for (int i = 0; i < todasSomasDigitos.length; i++) {
            int somaDigitos = 0;
            for (int j = i; j > 0; j /= 10) {
                somaDigitos += j % 10;
            }  
            todasSomasDigitos[i] = somaDigitos;  
        }

        tk = new StringTokenizer(in.readLine());
        int s = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());
        int b = Integer.parseInt(tk.nextToken());

        int res = 0;
        for (int i = a; i <= b; i++) {
            if (todasSomasDigitos[i] == s) res++;
        }
        System.out.println(res);

    }    
}