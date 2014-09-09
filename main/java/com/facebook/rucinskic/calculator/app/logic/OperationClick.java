package com.facebook.rucinskic.calculator.app.logic;

import android.view.View;

import com.facebook.rucinskic.calculator.app.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.strategy.Operation;
import com.facebook.rucinskic.calculator.app.ui.ICalculatorAbstraction;

/**
 * Created by Christopher on 7/4/2014.
 */
public class OperationClick {

    private final BinaryOperation operator;
    private View.OnClickListener listener;

    public OperationClick(final BinaryOperation operator) { this.operator = operator; }

    public final View.OnClickListener listenerOn(final ICalculatorAbstraction UI) {

        if (listener != null) return listener;

        return listener = new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                final double total, num1, num2;
                final Operation operation = operator.getOperation();

                num1 = Double.parseDouble(UI.getFirstNumber());
                num2 = Double.parseDouble(UI.getSecondNumber());

                total = operation.execute(num1, num2);

                final ExpressionState expression = new ExpressionState.Builder()
                        .setFirstNumber(num1)
                        .setSecondNumber(num2)
                        .setTotal(total)
                        .setOperator(operator)
                        .buildFor(UI);

                UI.updateResult(expression);

            }
        };

    }

}
