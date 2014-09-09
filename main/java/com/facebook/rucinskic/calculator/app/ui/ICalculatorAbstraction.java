package com.facebook.rucinskic.calculator.app.ui;

import com.facebook.rucinskic.calculator.app.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.logic.BinaryOperation;

/**
 * Created by Christopher on 7/31/2014.
 */
public interface ICalculatorAbstraction {

    String getFirstNumber();
    String getSecondNumber();
    void updateResult(ExpressionState result);

    BinaryOperation.Display getOperatorDisplayMode();

}