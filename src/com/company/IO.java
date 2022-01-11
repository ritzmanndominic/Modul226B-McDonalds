package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    private static final String HOR_LINE = "═";
    private static final String VER_LINE = "║";
    private static final String TOP_LEFT_CORNER = "╔";
    private static final String BOTTOM_LEFT_CORNER = "╚";
    private static final String TOP_RIGHT_CORNER = "╗";
    private static final String BOTTOM_RIGHT_CORNER = "╝";
    private static final String SPACE = " ";

    public static int readRangedInt(int min, int max) {
        Scanner scn = new Scanner(System.in);
        int input = min - 1;
        try {
            input = scn.nextInt();
        } catch (InputMismatchException var6) {
            scn.nextLine();
        }

        while (input < min || input > max) {
            System.out.println("There was an Error, please repeat your input");
            try {
                input = scn.nextInt();
            } catch (InputMismatchException var5) {
                scn.nextLine();
            }
        }
        return input;
    }

    public static void drawSingleBox(String userText, int maxLength) {
        int[] lengthDifference;
        maxLength = Math.max(maxLength, userText.length());
        lengthDifference = getLength(maxLength, userText.length());
        System.out.print(TOP_LEFT_CORNER);
        System.out.print(HOR_LINE.repeat(maxLength));
        System.out.print(TOP_RIGHT_CORNER + "\n" + VER_LINE);
        System.out.print(SPACE.repeat(lengthDifference[1]));
        System.out.print(userText);
        System.out.print(SPACE.repeat(lengthDifference[2]));
        System.out.print(VER_LINE + "\n" + BOTTOM_LEFT_CORNER);
        System.out.print(HOR_LINE.repeat(maxLength));
        System.out.println(BOTTOM_RIGHT_CORNER);
    }

    public static void drawMultipleBox(int maxLength, int width, int height, String... userText) {
        int[] lengthDifference;
        for (String s : userText) {
            maxLength = Math.max(s.length(), maxLength);
        }
        int leftDistance = 2;
        int rightDistance = 1;
        for (int k = 0; k < height; k++) {
            for (int j = 0; j < width; j++) {
                System.out.print(TOP_LEFT_CORNER);
                System.out.print(HOR_LINE.repeat(maxLength));
                System.out.print(TOP_RIGHT_CORNER + SPACE.repeat(2));
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                String printText;
                if (k * width + j < userText.length) printText = userText[k * width + j];
                else printText = "";
                lengthDifference = getLength(maxLength, printText.length());
                System.out.print(VER_LINE);
                System.out.print(SPACE.repeat(lengthDifference[leftDistance]));
                System.out.print(printText);
                System.out.print(SPACE.repeat(lengthDifference[rightDistance]));
                System.out.print(VER_LINE + SPACE.repeat(2));
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(BOTTOM_LEFT_CORNER);
                System.out.print(HOR_LINE.repeat(maxLength));
                System.out.print(BOTTOM_RIGHT_CORNER + SPACE.repeat(2));
            }
            System.out.println();
        }
    }

    private static int[] getLength(int maxLength, int usedLength) {
        int[] lengthDifference = new int[3];
        lengthDifference[0] = maxLength - usedLength;
        lengthDifference[1] = lengthDifference[0] / 2;
        if (lengthDifference[0] % 2 == 1) lengthDifference[2] = lengthDifference[0] / 2 + 1;
        else lengthDifference[2] = lengthDifference[0] / 2;
        return lengthDifference;
    }
}