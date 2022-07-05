
package main;

import java.util.Scanner;
import main.RomanAlph;

public class Calc {
    Scanner scan;

    public Calc() {
        scan = new Scanner(System.in);
        start();
    }

    private void start() {
        String[] operation = scan.nextLine().split(" ");
        scan.close();
        if (operation.length != 3) {
            System.out.println("NOT MATH");
            System.exit(0);
        }
        operationDefinition(operation);
    }

    private void operationDefinition(String[] operation) {
        boolean isRoman = validateArguments(operation[0],operation[2]);
        switch(operation[1]) {
            case "+":
                if (!isRoman) System.out.println(plus(Integer.parseInt(operation[0]),Integer.parseInt(operation[2])));
                else System.out.println(plus(operation[0],operation[2]));
                break;
            case "-":
                try {
                    if (!isRoman) System.out.println(minus(Integer.parseInt(operation[0]),Integer.parseInt(operation[2])));
                    else System.out.println(minus(operation[0],operation[2]));
                }catch(NumberFormatException e) {
                    System.out.println("there are no negative numbers in the Roman system");
                    System.exit(0);
                }
                break;
            case "*":
                if (!isRoman) System.out.println(multiplication(Integer.parseInt(operation[0]),Integer.parseInt(operation[2])));
                else System.out.println(multiplication(operation[0],operation[2]));
                break;
            case "/":
                try {
                    if (!isRoman) System.out.println(division(Integer.parseInt(operation[0]),Integer.parseInt(operation[2])));
                    else System.out.println(division(operation[0],operation[2]));
                }catch(ArithmeticException e) {
                    System.out.println("division ze0r0");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("kavo?");

        }
    }

    private boolean validateArguments(String a, String b) {
        if (!RomanAlph.isRoman(a) || !RomanAlph.isRoman(b)) {
            try {
                Integer.parseInt(a);
                Integer.parseInt(b);
            }catch(Exception e) {
                System.out.println("ne ponyal sho?");
                System.exit(0);
            }
        }
        if (RomanAlph.isRoman(a) && RomanAlph.isRoman(b)) return true;
        return false;
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private String plus(String a, String b) {
        return RomanAlph.toRoman(RomanAlph.toArab(a) + RomanAlph.toArab(b));
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private String minus(String a, String b) {
        return RomanAlph.toRoman(RomanAlph.toArab(a) - RomanAlph.toArab(b));
    }

    private int multiplication(int a, int b) {
        return a * b;
    }

    private String multiplication(String a, String b) {
        return RomanAlph.toRoman(RomanAlph.toArab(a) * RomanAlph.toArab(b));
    }

    private int division(int a, int b) {
        return a / b;
    }

    private String division(String a, String b) {
        return RomanAlph.toRoman((int)(RomanAlph.toArab(a) / RomanAlph.toArab(b)));
    }
}