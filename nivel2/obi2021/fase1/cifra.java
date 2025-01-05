import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class cifra {
    public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    char[] alfabeto = new char[24];
    int aux = 0;
    for (int i = 0; i < 24; i++) {
        if ('a' + i + aux == 'w' || 'a' + i + aux == 'y') aux += 1;
        alfabeto[i] = (char) ('a' + i + aux);
    }
    
    char[] vogais = new char[] {'a', 'e', 'i', 'o', 'u'};
    int[] posicaoVogais = new int[5];
    aux = 0;
    for (int i = 0; i < 24; i++) {
        if (eVogal(alfabeto[i])) {
            posicaoVogais[aux] = i;
            aux++;
        }
    }

    char[] vogaisProx = new char[24];
    aux = 0;
    for (int i = 0; i < 24; i++) {
        if (aux == 4) {
            vogaisProx[i] = vogais[aux]; 
            continue; 
        }
        int a = Math.abs( posicaoVogais[aux] - i );
        int b = Math.abs( i - posicaoVogais[aux + 1] );
        if (a <= b) { 
            vogaisProx[i] = vogais[aux]; 
        }
        if (a > b) { 
            vogaisProx[i] = vogais[aux + 1]; 
            aux++; 
        }
    }

    char[] consoantesProx = new char[24];
    char consoanteProx = 'z';
    for (int i = 23; i >= 0; i--) {
        consoantesProx[i] = consoanteProx;
        consoanteProx = ( !eVogal(alfabeto[i]) ) ? alfabeto[i] : consoanteProx;
    }

    String linhaInput = in.readLine().trim();
    in.close();

    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < linhaInput.length(); i++) {
        aux = 0;
        char l = linhaInput.charAt(i);
        if (eVogal(l)) {
            stringBuffer.append(l);
        } else {
            if (l >= 'y') { aux = 2; }
            else if (l >= 'w') { aux = 1; }
            stringBuffer.append( l + "" + vogaisProx[l - 'a' - aux] + "" + consoantesProx[l - 'a' - aux] );
        }
    }

    System.out.println(stringBuffer.toString());
    
   } 

   static final boolean eVogal(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
   }
}
