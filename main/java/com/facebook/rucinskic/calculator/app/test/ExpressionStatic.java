package com.facebook.rucinskic.calculator.app.test;

/**
 * Created by Christopher on 7/9/2014.
 */
public enum ExpressionStatic implements IExpression {

    Number1("%s") {

        @Override
        public String formatRealExpression() {

            return Number.parse(Display.state.getFirstNumber())
                    .setMaximumDecimalPlace(6)
                    .toString();

        }
    },
    Operator(" %s ") {

        @Override
        public String formatRealExpression() {

            return Display.state.getOperator().toString();

        }

    },
    Number2("%s") {

        @Override
        public String formatRealExpression() {

            return Number.parse(Display.state.getSecondNumber())
                    .setMaximumDecimalPlace(6)
                    .toString();

        }
    },
    Result(" = %s") {

        @Override
        public String formatRealExpression() {

            return Number.parse(Display.state.getTotal())
                    .setMaximumDecimalPlace(10)
                    .toString();

        }
    };

    private final String defaultFormat;

    ExpressionStatic(final String format) { this.defaultFormat = format; }

    @Override
    public String getExpression() { return defaultFormat.replace("%s", formatRealExpression()); }
}
