/**
 * Created by flyingleafe on 05.11.13.
 */

import java.util.*;
import java.io.*;

public class B {
    FastScanner in;
    PrintWriter out;

    int[] a, b;
    boolean[] used;
    int n;

    public void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        b = a.clone();
        int min = n;
        for (int i = n - 1; i >= 0; --i) {
            if (b[i] > min) {
                used[b[i] - 1] = true;
                int j = b[i] - 2;
                while ((j >= 0) && (used[j] == false)) j--;
                b[i] = j + 1;
                used[j] = false;
                j = i;
                for (int k = n - 1; k >= 0; --k) {
                    if (used[k]) b[++j] = k + 1;
                }
                for (int k = 0; k < n; ++k)
                    out.printf("%d ", b[k]);
                break;
            } else {
                used[b[i] - 1] = true;
                min = b[i];
            }
            if(i == 0) {
                for(int k=0; k<n; ++k)
                    out.write("0 ");
            }
        }
        out.write('\n');
        b = a.clone();
        Arrays.fill(used, false);
        int max = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (b[i] < max) {
                used[b[i] - 1] = true;
                int j = b[i];
                while ((j < n) && (used[j] == false)) j++;
                b[i] = j + 1;
                used[j] = false;
                j = i;
                for (int k = 0; k < n; ++k) {
                    if (used[k]) b[++j] = k + 1;
                }
                for (int k = 0; k < n; ++k)
                    out.printf("%d ", b[k]);
                break;
            } else {
                used[b[i] - 1] = true;
                max = b[i];
            }
            if(i == 0) {
                for(int k=0; k<n; ++k)
                    out.write("0 ");
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("nextperm.in"));
            out = new PrintWriter(new File("nextperm.out"));

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
        new B().run();
    }
}
