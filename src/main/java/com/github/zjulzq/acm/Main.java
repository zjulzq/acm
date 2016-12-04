package com.github.zjulzq.acm;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if ("0.00".equals(input)) {
                break;
            }
            double target = Double.valueOf(input);
            int cards = 0;
            double total = 0;
            while (true) {
                cards++;
                total += 1.0 / (cards + 1);
                if (total >= target) {
                    System.out.println(cards + " card(s)");
                    break;
                }
            }
        }
    }


}
