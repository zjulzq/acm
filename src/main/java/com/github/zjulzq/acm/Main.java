package com.github.zjulzq.acm;


import java.util.*;

public class Main {
    private static Map<String, Integer> haabMonthes = new HashMap<String, Integer>();
    private static String[] tzolkinDays = new String[260];

    static {
        haabMonthes.put("pop", 0);
        haabMonthes.put("no", 1);
        haabMonthes.put("zip", 2);
        haabMonthes.put("zotz", 3);
        haabMonthes.put("tzec", 4);
        haabMonthes.put("xul", 5);
        haabMonthes.put("yoxkin", 6);
        haabMonthes.put("mol", 7);
        haabMonthes.put("chen", 8);
        haabMonthes.put("yax", 9);
        haabMonthes.put("zac", 10);
        haabMonthes.put("ceh", 11);
        haabMonthes.put("mac", 12);
        haabMonthes.put("kankin", 13);
        haabMonthes.put("muan", 14);
        haabMonthes.put("pax", 15);
        haabMonthes.put("koyab", 16);
        haabMonthes.put("cumhu", 17);
        haabMonthes.put("uayet", 18);

        String dayLine = "imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, canac, ahau";
        String[] days = dayLine.split(",");
        for (int i = 0; i < days.length; i++) {
            days[i] = days[i].trim();
        }
        int monthIterator = 1;
        int dayIterator = 0;
        for (int i = 0; i < tzolkinDays.length; i++) {
            tzolkinDays[i] = monthIterator + " " + days[dayIterator].trim();
            monthIterator++;
            if (monthIterator > 13) {
                monthIterator = monthIterator % 13;
            }
            dayIterator++;
            if (dayIterator > 19) {
                dayIterator = dayIterator % 20;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine().trim());
        String[] output = new String[count + 1];
        output[0] = String.valueOf(count);
        for (int i = 0; i < count; i++) {
            String haab = scanner.nextLine();
            int days = convertHaab2Days(haab);
            String tzolkin = convertDays2Tzolkin(days);
            output[i + 1] = tzolkin;
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    private static int convertHaab2Days(String haab) {
        haab = haab.replace(".", "");
        String[] tmps = haab.split(" ");
        int day = Integer.valueOf(tmps[0]);
        String month = tmps[1].trim();
        int year = Integer.valueOf(tmps[2]);

        int total = 0;
        total = year * 365;
        if (month.equals("uayet")) {
            total += 18 * 20;
        } else {
            total += haabMonthes.get(month) * 20;
        }

        total += (day + 1);
        return total;
    }

    private static String convertDays2Tzolkin(int days) {
        int year = days / 260;
        int remain = days % 260;
        if (remain == 0) {
            year = year - 1;
            return tzolkinDays[tzolkinDays.length - 1] + " " + year;
        } else {
            return tzolkinDays[remain - 1] + " " + year;
        }
    }

}
