package com.oewami.flooring.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserIO implements ReadableIO {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String nextLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public BigDecimal nextBigDecimal(String prompt) {
        System.out.println(prompt);
        return scanner.nextBigDecimal();
    }
}
