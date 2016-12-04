package com.github.zjulzq.acm;


import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigDecimal r = scanner.nextBigDecimal();
            int n = scanner.nextInt();
            r = r.pow(n);

            String output = r.stripTrailingZeros().toPlainString();
            if (output.startsWith("0") && output.length() > 1) {
                System.out.println(output.substring(1));
            } else {
                System.out.println(output);
            }
        }
    }

}
