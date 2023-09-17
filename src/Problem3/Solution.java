package Problem3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (!flag && arr[i] < arr[i - 1]) {
                flag = true;
                ans[i] = ans[i - 1];
            } else if (flag && arr[i] > arr[i - 1]) {
                flag = false;
                ans[i] = i - 1;
            } else {
                ans[i] = ans[i - 1];
            }
        }
        int m = input.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < m; j++) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (ans[y - 1] <= x - 1) {
                answer.append("YES").append("\n");
            }
            else{
                answer.append("NO").append("\n");
            }
        }
        System.out.println(answer);

    }

    private static void update(int x, int y, int[] arr, StringBuilder answer) {
        //String answerCurrent = "NO";
        int xNew = x - 1;
        int yNew = y - 1;
        if (x == y) {
            answer.append("YES").append("\n");
        } else {
            boolean flagUp = true;
            if (arr[xNew] > arr[xNew + 1]) {
                answer.append("NO").append("\n");
            } else {
                for (int i = xNew; i <= yNew - 1; i++) {
                    int first = arr[i];
                    int second = arr[i + 1];
                    if (first < second) {
                        if (flagUp) {
                        } else {
                            answer.append("NO").append("\n");
                            return;
                        }
                    } else if (first > second) {
                        if (flagUp) {
                            flagUp = false;
                        }
                    }
                }
                answer.append("YES").append("\n");
            }
        }

    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
