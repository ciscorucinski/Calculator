package com.facebook.rucinskic.calculator.app.logic.strategy.algorithm;

/**
 * Created by Christopher on 7/4/2014.
 */
public class Subtract implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) {

        return a - b;

    }
}
