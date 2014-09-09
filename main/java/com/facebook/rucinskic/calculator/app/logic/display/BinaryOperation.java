package com.facebook.rucinskic.calculator.app.logic.display;

import com.facebook.rucinskic.calculator.app.logic.builder.OperationDisplay;
import com.facebook.rucinskic.calculator.app.logic.strategy.Operation;
import com.facebook.rucinskic.calculator.app.logic.strategy.algorithm.Add;
import com.facebook.rucinskic.calculator.app.logic.strategy.algorithm.Divide;
import com.facebook.rucinskic.calculator.app.logic.strategy.algorithm.Multiple;
import com.facebook.rucinskic.calculator.app.logic.strategy.algorithm.Subtract;
import static com.facebook.rucinskic.calculator.app.logic.display.BinaryOperation.Display.*;

public enum BinaryOperation {

    Add (
            new Operation(new Add()),
            new OperationDisplay.Builder()
                .setString(Sign, "+")
                .setString(Verb, "Add")
                .setString(Noun, "Addition")
                .build()),
    Subtract (
            new Operation(new Subtract()),
            new OperationDisplay.Builder()
                .setString(Sign, "-")
                .setString(Verb, "Subtract")
                .setString(Noun, "Subtraction")
                .build()),
    Multiply (
            new Operation(new Multiple()),
            new OperationDisplay.Builder()
                .setString(Sign, "×")
                .setString(Verb, "Multiply")
                .setString(Noun, "Multiplication")
                .build()),
    Divide (
            new Operation(new Divide()),
            new OperationDisplay.Builder()
                .setString(Sign, "÷")
                .setString(Verb, "Divide")
                .setString(Noun, "Division")
                .build());

    private final Operation operation;
    private final OperationDisplay stringOperation;

    private Display displayMode;

    BinaryOperation(final Operation operation, final OperationDisplay stringOperation) {

        this.operation = operation;
        this.stringOperation = stringOperation;

    }

    public Operation getOperation() { return this.operation; }

    @Override
    public String toString() { return this.stringOperation.getString(displayMode); }

    public void setDisplayMode(final Display displayMode) { this.displayMode = displayMode; }

    public enum Display { Sign, Verb, Noun }
}