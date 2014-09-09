package com.facebook.rucinskic.calculator.app.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.facebook.rucinskic.calculator.app.R;
import com.facebook.rucinskic.calculator.app.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.test.Expression;

import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.*;

public class MainActivity extends BaseCalculatorActivity {

    private EditText txtNumber1, txtNumber2, txtResult;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeOperationButtons();

        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult = (EditText) findViewById(R.id.txtResult);

    }

    @Override
    public String getFirstNumber() { return getNumberAsString(txtNumber1); }

    @Override
    public String getSecondNumber() { return getNumberAsString(txtNumber2); }

    @Override
    public void updateResult(final ExpressionState result) {

        this.txtResult.setText(new Publish(result).as(Expression.class));

    }

    @Override
    protected Display getDefaultDisplayMode() { return Display.Sign; }

}