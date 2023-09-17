package Problem2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int answer = 0;
        String s = input.nextLine();
        int[] arr = new int[256];
        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int index = (int) current;
            arr[index]++;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {

            } else {
                int currentNumber = arr[i];
                if (k == 0) {
                    answer++;
                } else {
                    if (k >= currentNumber) {
                        k -= currentNumber;
                    }
                    else{
                        k = 0;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
        //char test = 'A';
        //int number = (int) test;
        //System.out.println(number);
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
