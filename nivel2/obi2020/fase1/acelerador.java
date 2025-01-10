// acelerador de particulas

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acelerador {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println( ((Integer.parseInt(in.readLine().trim()) - 3) % 8) - 2 );
    }
}