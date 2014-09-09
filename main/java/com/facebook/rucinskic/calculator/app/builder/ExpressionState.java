package com.facebook.rucinskic.calculator.app.builder;

import com.facebook.rucinskic.calculator.app.logic.BinaryOperation;
import com.facebook.rucinskic.calculator.app.ui.ICalculatorAbstraction;

/**
* Created by Christopher on 8/2/2014.
*/
public class ExpressionState {

    private final Builder builder;

    private ExpressionState(final Builder builder) { this.builder = builder; }

    public double getFirstNumber() { return builder.number1; }
    public double getSecondNumber() { return builder.number2; }
    public BinaryOperation getOperator() { return builder.operator; }
    public double getTotal() { return builder.total; }

    public static class Builder {

        private double number1, number2, total;
        private BinaryOperation operator;

        public Builder setFirstNumber(final double number) { number1 = number; return this; }
        public Builder setSecondNumber(final double number) { number2 = number; return this; }
        public Builder setOperator(final BinaryOperation sign) { operator = sign; return this; }
        public Builder setTotal(final double number) { total = number; return this; }

        public ExpressionState buildFor(final ICalculatorAbstraction UI) {

            operator.setDisplayMode(UI.getOperatorDisplayMode());
            return new ExpressionState(this); }

    }

}
