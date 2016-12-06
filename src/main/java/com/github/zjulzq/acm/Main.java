package com.github.zjulzq.acm;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long total = 0;
        for (int i = 0; i < 12; i++) {
            String closing = scanner.next();
            closing = closing.replace(".", "");
            long tmp = Long.valueOf(closing);
            total += tmp;
        }
        long average = (long) (total / 12.0 + 0.5);
        String target = String.valueOf(average);
        if (target.length() == 1) {
            target = "0.0" + target;
        } else if (target.length() == 2) {
            target = "0." + target;
        } else {
            target = target.substring(0, target.length() - 2) + "." + target.substring(target.length() - 2);
        }
        System.out.println("$" + target);
    }


}
