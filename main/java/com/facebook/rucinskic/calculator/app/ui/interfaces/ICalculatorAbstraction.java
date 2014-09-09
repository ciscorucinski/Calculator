package com.facebook.rucinskic.calculator.app.ui.interfaces;

import com.facebook.rucinskic.calculator.app.logic.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.logic.display.BinaryOperation;

/**
 * Created by Christopher on 7/31/2014.
 */
public interface ICalculatorAbstraction {

    String getFirstNumber();
    String getSecondNumber();
    void updateResult(ExpressionState result);

    BinaryOperation.Display getOperatorDisplayMode();

}