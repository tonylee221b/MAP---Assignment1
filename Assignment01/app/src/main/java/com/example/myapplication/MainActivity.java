package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Calculator cal = new Calculator();
    TextView inputWindow;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPlus, btnMinus, btnMulti, btnDivide, btnEqual, btnClear, btnMode, btnMod, btnPow, btnMax, btnMin;
    LinearLayout advOperators;
    String resStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputWindow = findViewById(R.id.input_window);
        advOperators = findViewById((R.id.adv_Operators));
        advOperators.setVisibility(View.INVISIBLE);

        // 0 ~ 1 Buttons
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);

        // Operator Buttons
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDivide = findViewById(R.id.btn_divide);
        btnMulti = findViewById(R.id.btn_multi);
        btnEqual = findViewById(R.id.btn_eql);
        btnClear = findViewById(R.id.btn_clear);

        btnMod = findViewById(R.id.btn_mod);
        btnPow = findViewById(R.id.btn_pow);
        btnMax = findViewById(R.id.btn_max);
        btnMin = findViewById(R.id.btn_min);

        // Mode Button
        btnMode = findViewById(R.id.btn_mode);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        // Advanced Mode Operators
        btnMode.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnMax.setOnClickListener(this);
        btnMin.setOnClickListener(this);

        Log.d("Assignment1 - part 1", "on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Assignment1 - part 1", "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Assignment1 - part 1", "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Assignment1 - part 1", "on Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Assignment1 - part 1", "on Destroy");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int res = 0;

        if (resStr != "") {
            cal.clear();
            resStr = "";
        }

        switch (id) {
            case R.id.btn_0:
                cal.push("0");
                break;
            case R.id.btn_1:
                cal.push("1");
                break;
            case R.id.btn_2:
                cal.push("2");
                break;
            case R.id.btn_3:
                cal.push("3");
                break;
            case R.id.btn_4:
                cal.push("4");
                break;
            case R.id.btn_5:
                cal.push("5");
                break;
            case R.id.btn_6:
                cal.push("6");
                break;
            case R.id.btn_7:
                cal.push("7");
                break;
            case R.id.btn_8:
                cal.push("8");
                break;
            case R.id.btn_9:
                cal.push("9");
                break;
            case R.id.btn_plus:
                cal.push("+");
                break;
            case R.id.btn_minus:
                cal.push("-");
                break;
            case R.id.btn_divide:
                cal.push("/");
                break;
            case R.id.btn_multi:
                cal.push("*");
                break;
            case R.id.btn_eql:
                resStr = cal.print();
                res = cal.calculate();
                if (res == -9999) {
                    cal.clear();
                    resStr += "= Not an Operator";
                } else {
                    resStr += "= " + String.format("%d", res);
                }
                cal.push(resStr);
                break;
            case R.id.btn_clear:
                cal.clear();
                break;

            case R.id.btn_mod:
                cal.push("%");
                break;
            case R.id.btn_pow:
                cal.push("pow");
                break;
            case R.id.btn_max:
                cal.push("Max");
                break;
            case R.id.btn_min:
                cal.push("Min");
                break;
            case R.id.btn_mode:
                if (btnMode.getText() == "STANDARD") {
                    btnMode.setText("ADVANCE - SCIENTIFIC");
                    advOperators.setVisibility(View.INVISIBLE);
                } else {
                    btnMode.setText("STANDARD");
                    advOperators.setVisibility(View.VISIBLE);
                }
                break;
        }

        inputWindow.setText(cal.print());
    }
}