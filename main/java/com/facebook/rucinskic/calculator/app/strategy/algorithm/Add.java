package com.facebook.rucinskic.calculator.app.strategy.algorithm;

/**
 * Created by Christopher on 7/4/2014.
 */
public class Add implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) {

        return a + b;

    }

}
