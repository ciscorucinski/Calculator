package com.facebook.rucinskic.calculator.app.strategy;

import com.facebook.rucinskic.calculator.app.strategy.algorithm.IOperationStrategy;

/**
 * Created by Christopher on 7/4/2014.
 */
public class  Operation {

    private final IOperationStrategy strategy;

    public Operation(final IOperationStrategy strategy) { this.strategy = strategy; }

    public double execute(final double a, final double b) { return strategy.executeOperation(a, b); }

}
