package com.github.zjulzq.acm;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int e = scanner.nextInt();
            int i = scanner.nextInt();
            int d = scanner.nextInt();
            if (p == -1 && e == -1 && i == -1 && d == -1) {
                break;
            }
            int[] input = new int[]{p, e, i, d};
            int target = calc(input);
            count++;
            System.out.println(String.format("Case %d: the next triple peak occurs in %d days.", count, target - d));
        }

    }

    private static int calc(int[] input) {
        int p = input[0];
        int e = input[1];
        int i = input[2];
        int d = input[3];

        if (p == e && e == i) {
            return p + 21252;
        }

        int max = d + 21252;
        int minus = 21252;

        int p0 = p % 23;
        int e0 = e % 28;
        int i0 = i % 33;


        int p1 = 0;
        int e1 = 0;
        int i1 = 0;

        for (int j = 1; ; j++) {
            int tmp = 23 * 28 * j;
            if (tmp % 33 == 1) {
                i1 = tmp;
                break;
            }
        }

        for (int j = 1; ; j++) {
            int tmp = 23 * 33 * j;
            if (tmp % 28 == 1) {
                e1 = tmp;
                break;
            }
        }

        for (int j = 1; ; j++) {
            int tmp = 28 * 33 * j;
            if (tmp % 23 == 1) {
                p1 = tmp;
                break;
            }
        }

        int satisfy = p1 * p0 + e1 * e0 + i1 * i0;
        if (satisfy == 0) {
            satisfy = minus;
        }
        for (int j = 0; ; j++) {
            int tmp = satisfy - j * minus;
            if (tmp > d && tmp - minus <= d) {
                return tmp;
            }
        }

    }

}
