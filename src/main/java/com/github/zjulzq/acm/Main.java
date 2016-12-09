package com.github.zjulzq.acm;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Position position;
    private static Position newPosition;
    private static List<Integer> diff = new ArrayList<Integer>();
    private static List<String> output = new ArrayList<String>();

    static class Position {
        int width;
        int row;
        int column;
        int count;

        Position(int width, int row, int column, int count) {
            this.width = width;
            this.row = row;
            this.column = column;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        output.clear();
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if ("0".equals(line)) {
                break;
            }
            int width = Integer.valueOf(line);
            int[] first = new int[width];
            int[] second = new int[width];
            int[] third = new int[width];
            int[] fourth = new int[width];
            int[] fifth = new int[width];
            diff.clear();
            output.add(String.valueOf(width));
            position = new Position(width, 0, 0, 0);
            while (scanner.hasNext()) {
                line = scanner.nextLine().trim();
                if ("0 0".equals(line)) {
                    break;
                }
                String[] split = line.split(" ");
                int value = Integer.valueOf(split[0]);
                int length = Integer.valueOf(split[1]);
                int newCount = position.count + length;
                int newRow = newCount / width;
                int newColumn = newCount % width;
                newPosition = new Position(width, newRow, newColumn, newCount);

                if (position.row == 0) {
                    if (newPosition.row == 0) {
                        //1
                        fill1stArray(first, value);
                    } else if (newPosition.row == 1) {
                        //12
                        fill1stArray(first, value);
                        fillLastArray(second, value);
                        calc1stRowWithout3rdRow(first, second);
                    } else if (newPosition.row == 2) {
                        //122
                        fill1stArray(first, value);
                        fillMiddleArray(second, value);
                        fillLastArray(third, value);
                        calc1stRowWith3rdRow(first, second);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(first, second, third);
                        }
                    } else if (newPosition.row == 3) {
                        //1223
                        fill1stArray(first, value);
                        fillMiddleArray(second, value);
                        fillLastArray(third, value);
                        calc1stRowWith3rdRow(first, second);
                        calcMiddleRow(first, second, second, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(second, second, third);
                        }
                        copy(second, first);
                    } else {
                        //12223
                        fill1stArray(first, value);
                        fillMiddleArray(second, value);
                        fillLastArray(third, value);
                        calc1stRowWith3rdRow(first, second);
                        calcMiddleRow(first, second, second, width);
                        addDiff2Output();
                        int gap = newPosition.row - position.row - 3;
                        addZero2Output(gap * width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(second, second, third);
                        }
                        copy(second, first);
                    }

                } else if (position.row == 1) {
                    if (newPosition.row - position.row == 0) {
                        // 12
                        fill1stArray(second, value);
                        calc1stRowWithout3rdRow(first, second);
                    } else if (newPosition.row - position.row == 1) {
                        // 123
                        fill1stArray(second, value);
                        fillLastArray(third, value);
                        calc1stRowWith3rdRow(first, second);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(first, second, third);
                        }
                    } else if (newPosition.row - position.row == 2) {
                        // 1234
                        fill1stArray(second, value);
                        fillMiddleArray(third, value);
                        fillLastArray(fourth, value);
                        calc1stRowWith3rdRow(first, second);
                        calcMiddleRow(first, second, third, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(second, third, fourth);
                        }
                        copy(second, first);
                        copy(third, second);
                        copy(fourth, third);
                    } else if (newPosition.row - position.row == 3) {
                        // 12334
                        fill1stArray(second, value);
                        fillMiddleArray(third, value);
                        fillLastArray(fourth, value);
                        calc1stRowWith3rdRow(first, second);
                        calcMiddleRow(first, second, third, width);
                        calcMiddleRow(second, third, third, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(third, third, fourth);
                        }
                        copy(third, first);
                        copy(third, second);
                        copy(fourth, third);
                    } else {
                        // 123334
                        fill1stArray(second, value);
                        fillMiddleArray(third, value);
                        fillLastArray(fourth, value);
                        calc1stRowWith3rdRow(first, second);
                        calcMiddleRow(first, second, third, width);
                        calcMiddleRow(second, third, third, width);

                        int gap = newPosition.row - position.row - 3;
                        addZero2Output(gap * width);

                        if (newPosition.column > 0) {
                            calcLastBut1Row(third, third, fourth);
                        }
                        copy(third, first);
                        copy(third, second);
                        copy(fourth, third);
                    }
                } else {
                    if (newPosition.row - position.row == 0) {
                        // 123
                        fill1stArray(third, value);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(first, second, third);
                        }
                    } else if (newPosition.row - position.row == 1) {
                        // 1234
                        fill1stArray(third, value);
                        fillLastArray(fourth, value);
                        calcMiddleRow(first, second, third, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(second, third, fourth);
                        }
                        copy(second, first);
                        copy(third, second);
                        copy(fourth, third);
                    } else if (newPosition.row - position.row == 2) {
                        // 12345
                        fill1stArray(third, value);
                        fillMiddleArray(fourth, value);
                        fillLastArray(fifth, value);
                        calcMiddleRow(first, second, third, width);
                        calcMiddleRow(second, third, fourth, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(third, fourth, fifth);
                        }
                        copy(third, first);
                        copy(fourth, second);
                        copy(fifth, third);
                    } else if (newPosition.row - position.row == 3) {
                        // 123445
                        fill1stArray(third, value);
                        fillMiddleArray(fourth, value);
                        fillLastArray(fifth, value);
                        calcMiddleRow(first, second, third, width);
                        calcMiddleRow(second, third, fourth, width);
                        calcMiddleRow(third, fourth, fourth, width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(fourth, fourth, fifth);
                        }
                        copy(fourth, first);
                        copy(fourth, second);
                        copy(fifth, third);
                    } else {
                        // 1234445
                        fill1stArray(third, value);
                        fillMiddleArray(fourth, value);
                        fillLastArray(fifth, value);
                        calcMiddleRow(first, second, third, width);
                        calcMiddleRow(second, third, fourth, width);
                        calcMiddleRow(third, fourth, fourth, width);
                        int gap = newPosition.row - position.row - 3;
                        addZero2Output(gap * width);
                        if (newPosition.column > 0) {
                            calcLastBut1Row(fourth, fourth, fifth);
                        }
                        copy(fourth, first);
                        copy(fourth, second);
                        copy(fifth, third);
                    }
                }

                addDiff2Output();
                position = newPosition;
            }

            output.add("0 0");
        }
        output.add("0");
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    private static void addZero2Output(int count) {
        addStr2Output("0 " + count);
    }

    private static void addStr2Output(String str) {
        if (output.isEmpty()) {
            output.add(str);
        } else {
            String pair = output.get(output.size() - 1);
            String[] split = pair.split(" ");
            if (split.length == 2) {
                int lastValue = Integer.valueOf(split[0]);
                int lastCount = Integer.valueOf(split[1]);

                if (lastCount != 0) {
                    String[] newPair = str.split(" ");
                    int newValue = Integer.valueOf(newPair[0]);
                    int newCount = Integer.valueOf(newPair[1]);

                    if (newValue == lastValue) {
                        int count = lastCount + newCount;
                        output.remove(output.size() - 1);
                        output.add(newValue + " " + count);
                    } else {
                        output.add(str);
                    }
                } else {
                    output.add(str);
                }
            } else {
                output.add(str);
            }
        }

    }

    private static void addDiff2Output() {
        Integer target = null;
        int count = 0;
        for (int i = 0; i < diff.size(); i++) {
            if (target == null) {
                target = diff.get(i);
                count = 1;
            } else {
                if (target.intValue() == diff.get(i).intValue()) {
                    count++;
                } else {
                    String str = target.intValue() + " " + count;
                    addStr2Output(str);
                    target = diff.get(i);
                    count = 1;
                }
            }
            if (i == diff.size() - 1) {
                String str = target.intValue() + " " + count;
                addStr2Output(str);
            }
        }
        diff.clear();
    }

    private static void copy(int[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
    }

    private static void fill1stArray(int[] target, int val) {
        if (newPosition.row == position.row) {
            for (int i = position.column; i < newPosition.column; i++) {
                target[i] = val;
            }
        } else {
            for (int i = position.column; i < target.length; i++) {
                target[i] = val;
            }
        }
    }

    private static void fillLastArray(int[] target, int val) {
        for (int i = 0; i < newPosition.column; i++) {
            target[i] = val;
        }
    }

    private static void fillMiddleArray(int[] target, int val) {
        for (int i = 0; i < target.length; i++) {
            target[i] = val;
        }
    }


    private static void calc1stRowWithout3rdRow(int[] first, int[] second) {
        int range = newPosition.column - 1;
        calc1stRow(first, second, range);
    }

    private static void calc1stRowWith3rdRow(int[] first, int[] second) {
        calc1stRow(first, second, first.length);
    }

    private static void calc1stRow(int[] first, int[] second, int range) {
        for (int i = position.column; i < range; i++) {
            if (i == 0) {
                diff.add(maxAbs(first[i] - first[i + 1], first[i] - second[i], first[i] - second[i + 1]));
            } else if (i == first.length - 1) {
                diff.add(maxAbs(first[i] - first[i - 1], first[i] - second[i], first[i] - second[i - 1]));
            } else {
                diff.add(maxAbs(first[i] - first[i - 1], first[i] - first[i + 1], first[i] - second[i - 1], first[i] - second[i], first[i] - second[i + 1]));
            }
        }
    }

    private static void calcLastBut1Row(int[] first, int[] second, int[] third) {
        int range = newPosition.column - 1;
        calcMiddleRow(first, second, third, range);
    }


    private static void calcMiddleRow(int[] first, int[] second, int[] third, int range) {
        for (int i = 0; i < range; i++) {
            if (i == 0) {
                diff.add(maxAbs(second[i] - first[i], second[i] - first[i + 1], second[i] - second[i + 1], second[i] - third[i], second[i] - third[i + 1]));
            } else if (i == first.length - 1) {
                diff.add(maxAbs(second[i] - first[i - 1], second[i] - first[i], second[i] - second[i - 1], second[i] - third[i - 1], second[i] - third[i]));
            } else {
                diff.add(maxAbs(second[i] - first[i - 1], second[i] - first[i], second[i] - first[i + 1], second[i] - second[i - 1], second[i] - second[i + 1], second[i] - third[i - 1], second[i] - third[i], second[i] - third[i + 1]));
            }
        }
    }


    private static int maxAbs(int a, int b, int c) {
        int x = Math.max(Math.abs(a), Math.abs(b));
        return Math.max(x, Math.abs(c));
    }

    private static int maxAbs(int a, int b, int c, int d, int e) {
        int x = maxAbs(a, b, c);
        return maxAbs(x, d, e);
    }

    private static int maxAbs(int a, int b, int c, int d, int e, int f, int g, int h) {
        int x = maxAbs(a, b, c);
        int y = maxAbs(d, e, f, g, h);
        return Math.max(x, y);
    }

}
