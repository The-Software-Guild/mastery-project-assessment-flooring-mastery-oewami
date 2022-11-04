package com.oewami.flooring.view;

import java.math.BigDecimal;

public interface ReadableIO {

    void print(String message);

    String nextLine(String prompt);

    BigDecimal nextBigDecimal(String prompt);
}
