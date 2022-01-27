package com.example.myapplication;

import java.util.ArrayList;

public class Calculator {

    ArrayList<String> input = new ArrayList<String>();
    String idx0;
    String idx1;
    String idx2;
    int count;
    int res;

    public Calculator() {};

    public void push(String value) {
        input.add(value);
    }

    public int calculate() {
        if (((input.size() % 2) == 0))
            return -9999;

        idx0 = "";
        idx1 = "";
        idx2 = "";
        count = 0;
        res = 0;

        do {
            if (count == 0) {
                idx0 = input.remove(0);
                idx1 = input.remove(0);
                idx2 = input.remove(0);

                if (!Character.isDigit(idx0.charAt(0)) || Character.isDigit(idx1.charAt(0)) || !Character.isDigit(idx2.charAt(0))) {
                    return -9999;
                } else {
                    switch (idx1) {
                        case "+":
                            res = Integer.parseInt(idx0) + Integer.parseInt((idx2));
                            break;
                        case "-":
                            res = Integer.parseInt(idx0) - Integer.parseInt((idx2));
                            break;
                        case "/":
                            res = Integer.parseInt(idx0) / Integer.parseInt((idx2));
                            break;
                        case "*":
                            res = Integer.parseInt(idx0) * Integer.parseInt((idx2));
                            break;

                        case "%":
                            res = Integer.parseInt(idx0) % Integer.parseInt((idx2));
                            break;
                        case "pow":
                            res = (int)Math.pow(Integer.parseInt(idx0), Integer.parseInt((idx2)));
                            break;
                        case "Max":
                            res = Math.max(Integer.parseInt(idx0), Integer.parseInt(idx2));
                            break;
                        case "Min":
                            res = Math.min(Integer.parseInt(idx0), Integer.parseInt(idx2));
                            break;
                    }
                }
            } else {
                idx0 = input.remove(0);
                idx1 = input.remove(0);

                if (Character.isDigit(idx0.charAt(0)) || !Character.isDigit(idx1.charAt(0))) {
                    return -9999;
                } else {
                    switch (idx0) {
                        case "+":
                            res += Integer.parseInt((idx1));
                            break;
                        case "-":
                            res -= Integer.parseInt((idx1));
                            break;
                        case "/":
                            res /= Integer.parseInt((idx1));
                            break;
                        case "*":
                            res *= Integer.parseInt((idx1));
                            break;

                        case "%":
                            res %= Integer.parseInt((idx1));
                            break;
                        case "pow":
                            res = (int)Math.pow(res, Integer.parseInt((idx1)));
                            break;
                        case "Max":
                            res = Math.max(res, Integer.parseInt(idx1));
                            break;
                        case "Min":
                            res = Math.min(res, Integer.parseInt(idx1));
                            break;
                    }
                }
            }

            ++count;
        } while(!input.isEmpty());

        return res;
    }

    public String print() {
        String output = "";

        for (String i : input) {
            output += i;
            output += " ";
        }

        return output;
    }

    public void clear() {
        input.clear();
        idx0 = "";
        idx1 = "";
        idx2 = "";
        count = 0;
        res = 0;
    }
}
