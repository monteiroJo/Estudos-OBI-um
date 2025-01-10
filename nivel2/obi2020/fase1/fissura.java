// fissura perigosa

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class xy{
    int x; int y;
    xy(int x, int y) {
        this.x = x; this.y = y;
    }
}
public class fissura {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int f = Integer.parseInt(tk.nextToken());

        char[][] matriz = new char[n][n];
        Queue<xy> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            matriz[i] = in.readLine().toCharArray();
        }
        in.close();

        xy[] direcoes = new xy[] { new xy(0, 1), new xy(1, 0), new xy(-1, 0), new xy(0, -1) };
        if (Character.digit(matriz[0][0], 10) <= f) {
            
            queue.add(new xy(0, 0));
            matriz[0][0] = '*';

            while (!queue.isEmpty()) {
                xy c = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int novox = c.x + direcoes[i].x;
                    int novoy = c.y + direcoes[i].y;
                    if ( novox >= 0 && novox < n && novoy >= 0 && novoy < n && Character.digit(matriz[novox][novoy], 10) <= f && matriz[novox][novoy] != '*') {
                        queue.add(new xy(novox, novoy));
                        matriz[novox][novoy] = '*';
                    } 
                }
                
            }
        } 
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.append(matriz[i][j]);
            }
            res.append("\n");
        }
        System.out.println(res.toString());

    }
}

