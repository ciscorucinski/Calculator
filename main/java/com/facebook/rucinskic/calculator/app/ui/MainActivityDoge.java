package com.facebook.rucinskic.calculator.app.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.facebook.rucinskic.calculator.app.R;
import com.facebook.rucinskic.calculator.app.logic.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.logic.display.ExpressionDoge;
import com.facebook.rucinskic.calculator.app.ui.interfaces.BaseCalculatorActivity;

import static com.facebook.rucinskic.calculator.app.logic.display.BinaryOperation.*;

/**
 * Created by Christopher on 8/1/2014.
 */
public class MainActivityDoge extends BaseCalculatorActivity {

    private EditText txtNumber1, txtResult;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doge);

        initializeOperationButtons();

        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtResult = (EditText) findViewById(R.id.txtResult);

    }

    @Override
    public String getFirstNumber() { return getNumberAsString(txtNumber1); }

    @Override
    public String getSecondNumber() { return "2"; }

    @Override
    public void updateResult(final ExpressionState result) {

        this.txtResult.setText(new Publish(result).as(ExpressionDoge.class));

    }

    @Override
    protected Display getDefaultDisplayMode() { return Display.Noun; }

}