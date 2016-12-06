package com.github.zjulzq.acm;


import java.util.Scanner;

public class Main {
    private static final String FORMAT = "Property %d: This property will begin eroding in year %d.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int z = calcYear(x, y);
            System.out.println(String.format(FORMAT, i + 1, z));
        }
        System.out.println("END OF OUTPUT.");
    }

    private static int calcYear(double x, double y) {
        double s = 0.5 * Math.PI * (x * x + y * y);
        int z = (int) (s / 50);
        return z + 1;
    }

}
