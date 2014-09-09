package com.facebook.rucinskic.calculator.app.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.facebook.rucinskic.calculator.app.R;
import com.facebook.rucinskic.calculator.app.logic.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.logic.display.ExpressionStatic;
import com.facebook.rucinskic.calculator.app.ui.interfaces.BaseCalculatorActivity;

import static com.facebook.rucinskic.calculator.app.logic.display.BinaryOperation.*;

public class MainActivityStatic extends BaseCalculatorActivity {

    private static final String PI  = String.valueOf(Math.PI);
    private static final String PHI = String.valueOf((Math.sqrt(5) + 1) / 2);

    private EditText txtResult;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeOperationButtons();

        final EditText txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        final EditText txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult  = (EditText) findViewById(R.id.txtResult);

        txtNumber1.setEnabled(false);
        txtNumber2.setEnabled(false);

        txtNumber1.setText(getFirstNumber());
        txtNumber2.setText(getSecondNumber());

    }

    @Override
    public String getFirstNumber() { return PI; }

    @Override
    public String getSecondNumber() { return PHI; }

    @Override
    public void updateResult(final ExpressionState result) {

        txtResult.setText(new Publish(result).as(ExpressionStatic.class));


    }

    @Override
    protected Display getDefaultDisplayMode() { return Display.Sign; }

}
