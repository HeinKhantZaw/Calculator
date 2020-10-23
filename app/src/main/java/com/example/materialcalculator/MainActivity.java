package com.example.materialcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one, two, three, four, five, six, seven, eight, nine, zero, dot, plus, minus, multiply, divide, modulus, clear, equal;
    private TextView screen, outputScreen;
    private double val1;
    private double val2;
    private char OPERATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("value", String.valueOf(val1));
        findViewByID();
        setOnClick();
    }

    private void setOnClick() {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s1", screen.getText().toString()));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s2", screen.getText().toString()));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s3", screen.getText().toString()));
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s4", screen.getText().toString()));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s5", screen.getText().toString()));
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s6", screen.getText().toString()));
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s7", screen.getText().toString()));
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s8", screen.getText().toString()));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s9", screen.getText().toString()));
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s0", screen.getText().toString()));
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeDisplay();
                screen.setText(String.format("%s.", screen.getText().toString()));
            }
        });

        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeOperation('%');
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeOperation('+');
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkBeforeOperation('-');
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeOperation('*');
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeOperation('/');
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBeforeOperation('=');
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                screen.setText("");
                outputScreen.setText("");
            }
        });
    }

    private void checkBeforeOperation(char c) {
        if (screen.getText().length() > 0) {
            OPERATION = c;
            operation();
            if (doubleTypeCheck()) {
                outputScreen.setText(String.valueOf(val1));
            } else {
                outputScreen.setText(String.valueOf((int) val1));
            }
            screen.setText(null);
        } else {
            outputScreen.setText(R.string.errorMsg);
        }
    }

    private void checkBeforeDisplay() {
        removeAnyErrorText();
        exceedLength();
    }

    private boolean doubleTypeCheck() {
        Log.d("real value:", String.valueOf(val1));
        Log.d("changed value:", String.valueOf((int) val1));
        return val1 != (int) val1;

    }

    private void removeAnyErrorText() {
        if (outputScreen.getText().toString().equals("Error")) {
            outputScreen.setText("");
        }
    }

    private void findViewByID() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        modulus = findViewById(R.id.modulus);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        screen = findViewById(R.id.screen);
        outputScreen = findViewById(R.id.output_screen);
    }

    private void exceedLength() {
        Log.d("count", String.valueOf(screen.getText().toString().length()));
        if (screen.getText().toString().length() >= 11) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("No space for more numbers :((")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            screen.setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    private void operation() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(screen.getText().toString());

            switch (OPERATION) {
                case '+':
                    val1 = val1 + val2;
                    break;
                case '-':
                    val1 = val1 - val2;
                    break;
                case '*':
                    val1 = val1 * val2;
                    break;
                case '/':
                    val1 = val1 / val2;
                    break;
                case '%':
                    val1 = val1 % val2;
                    break;
                case '=':
                    break;
            }
        } else {
            val1 = Double.parseDouble(screen.getText().toString());
        }
    }
}