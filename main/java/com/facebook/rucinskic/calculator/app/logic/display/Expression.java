package com.facebook.rucinskic.calculator.app.logic.display;

import com.facebook.rucinskic.calculator.app.logic.display.*;
import com.facebook.rucinskic.calculator.app.logic.display.Number;

/**
 * Created by Christopher on 7/9/2014.
 */
public enum Expression implements IExpression {

    Number1 ("%s") {

        @Override
        public String formatRealExpression() {

            return com.facebook.rucinskic.calculator.app.logic.display.Number.parse(Display.state.getFirstNumber())
                    .setMaximumDecimalPlace(2)
                    .toString();

        }
    },
    Operator(" %s ") {

        @Override
        public String formatRealExpression() {

            return Display.state.getOperator().toString();

        }

    },
    Number2 ("%s") {

        @Override
        public String formatRealExpression() {

            return Number.parse(Display.state.getSecondNumber())
                    .setMaximumDecimalPlace(2)
                    .toString();

        }
    },
    Result  (" = %s") {

        @Override
        public String formatRealExpression() {

            return Number.parse(Display.state.getTotal())
                    .setMaximumDecimalPlace(4)
                    .toString();

        }
    };

    private final String defaultFormat;

    Expression(final String format) { this.defaultFormat = format; }

    @Override
    public String getExpression() { return defaultFormat.replace("%s", formatRealExpression()); }
}
