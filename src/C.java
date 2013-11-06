/**
 * Created by flyingleafe on 06.11.13.
 */
import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;

    int n, k;
    int[] a;

    public void solve() throws IOException {
        n = in.nextInt();
        k = in.nextInt();
        a = new int[k];
        for(int i=0; i<k; ++i)
            a[i] = in.nextInt();
        for(int i=k-1; i>=0; --i) {
            if(a[i] < n-k+i+1) {
                int t = ++a[i];
                for(int j = ++i; j<k; ++j) {
                    a[j] = ++t;
                }
                for(int j=0; j<k; ++j)
                    out.printf("%d ", a[j]);
                break;
            }
            if(i == 0) {
                out.write("-1");
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("nextchoose.in"));
            out = new PrintWriter(new File("nextchoose.out"));

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
        new C().run();
    }
}