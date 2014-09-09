package com.facebook.rucinskic.calculator.app.test;

import com.facebook.rucinskic.calculator.app.builder.ExpressionState;

/**
 * Created by Christopher on 8/22/2014.
 */
public interface IExpression {

    String getExpression();
    String formatRealExpression();

    class Display {

        protected static ExpressionState state;

        public static CharSequence getFullExpression(final Class<? extends IExpression> type, final ExpressionState state) {

            String replacedString = "";

            Display.state = state;

            for (final IExpression expression : type.getEnumConstants()) {

                replacedString += expression.getExpression();

            }

            return replacedString;

        }

   }

}
