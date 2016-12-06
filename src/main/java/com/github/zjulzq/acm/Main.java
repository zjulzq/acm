package com.github.zjulzq.acm;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
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
        System.out.println(System.currentTimeMillis() - start);

    }

    private static int calc(int[] input) {
        int p = input[0];
        int e = input[1];
        int i = input[2];
        int d = input[3];

        Set<Integer> setp = new HashSet<Integer>();
        Set<Integer> sete = new HashSet<Integer>();
        List<Integer> listi = new ArrayList<Integer>();

        int max = d + 21252;

        for (int j = 1; ; j++) {
            int tmp = p - j * 23;
            if (tmp < 0) {
                break;
            }
            if (tmp > d) {
                setp.add(tmp);
            }
        }

        for (int j = 0; ; j++) {
            int tmp = p + j * 23;
            if (tmp > max) {
                break;
            }
            if (tmp > d) {
                setp.add(tmp);
            }
        }

        for (int j = 1; ; j++) {
            int tmp = e - j * 28;
            if (tmp < 0) {
                break;
            }
            if (tmp > d) {
                sete.add(tmp);
            }
        }
        for (int j = 0; ; j++) {
            int tmp = e + j * 28;
            if (tmp > max) {
                break;
            }
            if (tmp > d) {
                sete.add(tmp);
            }
        }

        for (int j = 1; ; j++) {
            int tmp = i - j * 33;
            if (tmp < 0) {
                break;
            }
            if (tmp > d) {
                listi.add(tmp);
            }
        }
        for (int j = 0; ; j++) {
            int tmp = i + j * 33;
            if (tmp > max) {
                break;
            }
            if (tmp > d) {
                listi.add(tmp);
            }
        }

        for (Integer tmp : listi) {
            if (sete.contains(tmp) && setp.contains(tmp)) {
                return tmp;
            }
        }
        return max;
    }

}
