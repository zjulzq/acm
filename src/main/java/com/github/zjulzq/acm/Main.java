package com.github.zjulzq.acm;


import java.util.*;

public class Main {

    static class Tmp {
        String dna;
        int inversion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Tmp[] tmps = new Tmp[m];

        for (int i = 0; i < m; i++) {
            String dna = scanner.next();
            int inversion = calc(dna);
            Tmp tmp = new Tmp();
            tmp.dna = dna;
            tmp.inversion = inversion;
            tmps[i] = tmp;
        }

        for (int i = 0; i < tmps.length; i++) {
            for (int j = i + 1; j < tmps.length; j++) {
                if (tmps[i].inversion > tmps[j].inversion) {
                    Tmp tmp = tmps[i];
                    tmps[i] = tmps[j];
                    tmps[j] = tmp;
                }
            }
        }

        for (int i = 0; i < tmps.length; i++) {
            System.out.println(tmps[i].dna);
        }

    }

    private static int calc(String dna) {
        int inversion = 0;
        for (int i = 0; i < dna.length(); i++) {
            for (int j = i + 1; j < dna.length(); j++) {
                if (dna.charAt(i) > dna.charAt(j)) {
                    inversion++;
                }
            }
        }
        return inversion;
    }

}
