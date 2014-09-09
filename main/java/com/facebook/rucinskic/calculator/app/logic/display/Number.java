package com.facebook.rucinskic.calculator.app.logic.display;

import java.text.DecimalFormat;

/**
 * Created by Christopher on 7/9/2014.
 */
public final class Number {

    private final double number;

    private static DecimalFormat formatter;
    private DecimalFormat individualFormatter;

    public Number()                    { this(0.0); }
    public Number(final int number)    { this((double) number); }
    public Number(final double number) { this.number = number; }

    public String toString() {

        return (individualFormatter == null)
                ? formatter.format(number)
                : individualFormatter.format(number);

    }

    public static Number parse(final String number) {

        return new Number(Double.parseDouble(number));

    }

    public static Number parse(final double number) {

        return new Number(number);
    }

    public static void setDefaultDecimalPlaces(final int decimalPlaces) { formatter = getFormat(decimalPlaces); }

    public Number setMaximumDecimalPlace(final int decimalPlaces) {

        individualFormatter = getFormat(decimalPlaces);
        return this;

    }

    private static DecimalFormat getFormat(final int decimalPlaces) {

        String places = "0.";

        for (int i = 0; i < decimalPlaces; i++) places += "#";

        return new DecimalFormat(places);

    }

}
