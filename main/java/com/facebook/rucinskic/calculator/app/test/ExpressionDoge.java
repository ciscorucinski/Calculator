package com.facebook.rucinskic.calculator.app.test;

/**
 * Created by Christopher on 8/24/2014.
 */
public enum ExpressionDoge implements IExpression {

    Phrase  ("Wow. Such %s. ") {

        @Override
        public String formatRealExpression() {

            return Display.state.getOperator().toString();

        }
    },
    Total   ("%s") {

        @Override
        public String formatRealExpression() {

            return new Number(Display.state.getTotal())
                    .setMaximumDecimalPlace(2)
                    .toString();

        }
    };

    private final String defaultFormat;

    ExpressionDoge(final String format) { this.defaultFormat = format; }

    @Override
    public String getExpression() {

        return defaultFormat.replace("%s", formatRealExpression());

    }

}
