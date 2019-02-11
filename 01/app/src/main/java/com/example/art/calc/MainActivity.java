package com.example.art.calc;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float firstValue, secondValue;

    String operation = null;

    final String addition = "addition",
            subtraction = "subtraction",
            multiplication = "multiplication",
            division = "division";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();

        final Button button0 = (Button) findViewById(R.id.button0);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button buttonDot = (Button) findViewById(R.id.buttonDot);
        final Button buttonC = (Button) findViewById(R.id.buttonC);
        final Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        final Button buttonSub = (Button) findViewById(R.id.buttonSub);
        final Button buttonMul = (Button) findViewById(R.id.buttonMul);
        final Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        final Button buttonEq = (Button) findViewById(R.id.buttonEq);

        final EditText resultField = (EditText) findViewById(R.id.resultField);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.zero));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.one));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.two));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.three));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.four));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.five));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.six));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.seven));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.eight));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.nine));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText(resultField.getText() + res.getString(R.string.dot));
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultField.getText() == null) {
                    resultField.setText("");
                } else {
                    firstValue = Float.parseFloat(resultField.getText() + "");
                    operation = addition;
                    resultField.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultField.getText() == null) {
                    resultField.setText("");
                } else {
                    firstValue = Float.parseFloat(resultField.getText() + "");
                    operation = subtraction;
                    resultField.setText(null);
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultField.getText() == null) {
                    resultField.setText("");
                } else {
                    firstValue = Float.parseFloat(resultField.getText() + "");
                    operation = multiplication;
                    resultField.setText(null);
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultField.getText() == null) {
                    resultField.setText("");
                } else {
                    firstValue = Float.parseFloat(resultField.getText() + "");
                    operation = division;
                    resultField.setText(null);
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultField.setText("");
                operation = null;
            }
        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondValue = Float.parseFloat(resultField.getText() + "");

                String operationResult = getResult();

                resultField.setText(operationResult);

                operation = null;
            }
        });
    }

    private String getResult() {
        switch (operation) {
            case addition:
                return (firstValue + secondValue + "");

            case subtraction:
                return (firstValue - secondValue + "");

            case multiplication:
                return (firstValue * secondValue + "");

            case division:
                return (firstValue / secondValue + "");

            default:
                return "0";
        }
    }


}
