package com.facebook.rucinskic.calculator.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.rucinskic.calculator.app.builder.ExpressionState;
import com.facebook.rucinskic.calculator.app.logic.BinaryOperation;
import com.facebook.rucinskic.calculator.app.logic.OperationClick;
import com.facebook.rucinskic.calculator.app.R;
import com.facebook.rucinskic.calculator.app.test.IExpression;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.Add;
import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.Divide;
import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.Multiply;
import static com.facebook.rucinskic.calculator.app.logic.BinaryOperation.Subtract;

/**
 * Created by Christopher on 8/6/2014.
 */
public abstract class BaseCalculatorActivity extends Activity implements ICalculatorAbstraction {

    private BinaryOperation.Display display = getDefaultDisplayMode();

    protected abstract BinaryOperation.Display getDefaultDisplayMode();

    void initializeOperationButtons() {

        final Button btnAdd = (Button) findViewById(R.id.btnAddition);
        final Button btnSub = (Button) findViewById(R.id.btnSubtract);
        final Button btnMul = (Button) findViewById(R.id.btnMultiple);
        final Button btnDiv = (Button) findViewById(R.id.btnDivide);

        btnAdd.setOnClickListener(new OperationClick(Add).listenerOn(this));
        btnSub.setOnClickListener(new OperationClick(Subtract).listenerOn(this));
        btnMul.setOnClickListener(new OperationClick(Multiply).listenerOn(this));
        btnDiv.setOnClickListener(new OperationClick(Divide).listenerOn(this));

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the OPERATION bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        Intent intent = null;

        switch (item.getItemId()) {

            case R.id.action_calculator_simple: intent = new Intent(this, MainActivity.class); break;
            case R.id.action_calculator_doge:   intent = new Intent(this, MainActivityDoge.class); break;
            case R.id.action_calculator_static: intent = new Intent(this, MainActivityStatic.class); break;

            case R.id.action_calculator_sign: display = BinaryOperation.Display.Sign; return true;
            case R.id.action_calculator_verb: display = BinaryOperation.Display.Verb; return true;
            case R.id.action_calculator_noun: display = BinaryOperation.Display.Noun; return true;

            default: // Do nothing
        }

        if (intent != null) startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

    static String getNumberAsString(final EditText textBox) {

        final Editable text = textBox.getText();

        if (text.toString().isEmpty()) {

            textBox.setText("0");
            return "0";

        }

        return  text.toString();

    }

    public BinaryOperation.Display getOperatorDisplayMode() { return display; }

//    public CharSequence getFullResultString(ExpressionState state) {
//
//        return IExpression.Display.getFullExpression(expression.getClass(), state);
//
//    }

    class Publish {

        private final ExpressionState state;

        public Publish(final ExpressionState state) { this.state = state; }

        public CharSequence as(final Class<? extends IExpression> expression) {

            return IExpression.Display.getFullExpression(expression, state);

        }

    }

}