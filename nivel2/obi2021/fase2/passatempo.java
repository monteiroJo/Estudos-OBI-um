// passatempo

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class passatempo {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        TreeMap<String, Integer> variaveis = new TreeMap<>();

        tk = new StringTokenizer(in.readLine());
        int l = Integer.parseInt(tk.nextToken());
        int c = Integer.parseInt(tk.nextToken());

        String[][] quadriculado = new String[l][c];
        int[] somaDasLinhas = new int[l];
        int[] somaDasColunas  = new int[c];

        for (int i = 0; i < l; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < c; j++) {
                quadriculado[i][j] = tk.nextToken();
                if (!variaveis.containsKey(quadriculado[i][j])) {
                    variaveis.put(quadriculado[i][j], Integer.MIN_VALUE);
                }
            }
            somaDasLinhas[i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < c; i++) {
            somaDasColunas[i] = Integer.parseInt(tk.nextToken());
        }
        in.close();

        int encontrados = 0, vezesNovo, somaVelhos;
        boolean seNovo;
        String varia;
        while (encontrados < variaveis.size()) {
            
            for (int i = 0; i < l; i++) {
                seNovo = false; vezesNovo = 0; somaVelhos = 0; varia = "";

                for (int j = 0; j < c; j++) {
                    int attI = variaveis.get(quadriculado[i][j]);

                    if (!seNovo) {
                        if (attI == Integer.MIN_VALUE) {
                            seNovo = true; vezesNovo += 1; varia = quadriculado[i][j];
                        }
                        else {
                            somaVelhos += attI;
                        }
                    } 
                    else if (seNovo) {
                        if (varia.equals(quadriculado[i][j])) { 
                            vezesNovo += 1; 
                        }
                        else if (attI == Integer.MIN_VALUE) {
                            break;
                        }
                        else {
                            somaVelhos += attI;
                        }
                    }

                    if (j == c - 1 && seNovo) {
                        encontrados += 1;
                        variaveis.put(varia, (somaDasLinhas[i] - somaVelhos) / vezesNovo);
                    }
                }
            }

            for (int i = 0; i < c; i++) {
                seNovo = false; vezesNovo = 0; somaVelhos = 0; varia = "";

                for (int j = 0; j < l; j++) {
                    int attI = variaveis.get(quadriculado[j][i]);

                    if (!seNovo) {
                        if (attI == Integer.MIN_VALUE) {
                            seNovo = true; vezesNovo += 1; varia = quadriculado[j][i];
                        }
                        else {
                            somaVelhos += attI;
                        }
                    } 
                    else if (seNovo) {
                        if (varia.equals(quadriculado[j][i])) { 
                            vezesNovo += 1; 
                        }
                        else if (attI == Integer.MIN_VALUE) {
                            break;
                        }
                        else {
                            somaVelhos += attI;
                        }
                    }

                    if (j == l - 1 && seNovo) {
                        encontrados += 1;
                        variaveis.put(varia, (somaDasColunas[i] - somaVelhos) / vezesNovo);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> k  : variaveis.entrySet()) {
            System.out.println(k.getKey() + " " + k.getValue());
        }
    }
}