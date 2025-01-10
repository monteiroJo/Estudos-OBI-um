//  tempo de resposta

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tempo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int[] tempoDeEsperaDosAmigos = new int[101];
        boolean[] amigosEsperando = new boolean[101];

        tk = new StringTokenizer(in.readLine());
        int registros = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < registros; i++) {
            tk = new StringTokenizer(in.readLine());
            char letraDoEvento = tk.nextToken().charAt(0);
            int numeroDoEvento = Integer.parseInt(tk.nextToken());

            if (letraDoEvento != 'T') {
                for (int j = 1; j < 101; j++) {
                    if (amigosEsperando[j]) { tempoDeEsperaDosAmigos[j]++; }
                }
            }
            if (letraDoEvento == 'R') {
                amigosEsperando[numeroDoEvento] = true; 
            } 
            else if (letraDoEvento == 'E') {
                amigosEsperando[numeroDoEvento] = false;
            } 
            else if (letraDoEvento == 'T'){
                for (int j = 1; j < 101; j++) {
                    if (amigosEsperando[j]) { tempoDeEsperaDosAmigos[j] += (numeroDoEvento - 1); }
                }
            } 
        }
        in.close();

        for (int i = 1; i < 101; i++) {
            if (!amigosEsperando[i] && tempoDeEsperaDosAmigos[i] != 0)
                System.out.printf("%d %d%n", i, tempoDeEsperaDosAmigos[i]);
            else if (amigosEsperando[i]) 
                System.out.printf("%d -1%n", i);
        }

    }
}
