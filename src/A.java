/**
 * Created by flyingleafe on 05.11.13.
 */

import java.util.*;
import java.io.*;

public class A {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        String s = in.next();
        char[] v = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (v[i] == '1') {
                v[i] = '0';
                for (int j = i + 1; j < s.length(); ++j)
                    v[j] = '1';
                out.write(v);
                break;
            }
            if (i == 0) {
                out.write('-');
            }
        }
        out.write('\n');
        v = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (v[i] == '0') {
                v[i] = '1';
                for (int j = i + 1; j < s.length(); ++j)
                    v[j] = '0';
                out.write(v);
                break;
            }
            if (i == 0) {
                out.write('-');
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("nextvector.in"));
            out = new PrintWriter(new File("nextvector.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new A().run();
    }
}
