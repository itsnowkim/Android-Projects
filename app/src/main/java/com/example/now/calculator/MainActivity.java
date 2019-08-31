package com.example.now.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView num0;
    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView num7;
    TextView num8;
    TextView num9;
    TextView result;

    TextView plus;
    TextView minus;
    TextView multi;
    TextView devide;
    TextView moduler;
    TextView equal;
    TextView dot;
    TextView clear;

    ImageView del;

    Float first = null;
    Float second = null;
    String operator;
    String temp = "";
    boolean isnum = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find_Views();
        init();
        setupListeners();
    }
    public void init(){
        first = null;
        second = null;
        operator = "";
        temp = "";
        result.setText("0");
        isnum = false;
    }

    public void find_Views(){
        num0 = findViewById(R.id.number_0);
        num1 = findViewById(R.id.number_1);
        num2 = findViewById(R.id.number_2);
        num3 = findViewById(R.id.number_3);
        num4 = findViewById(R.id.number_4);
        num5 = findViewById(R.id.number_5);
        num6 = findViewById(R.id.number_6);
        num7 = findViewById(R.id.number_7);
        num8 = findViewById(R.id.number_8);
        num9 = findViewById(R.id.number_9);

        dot = findViewById(R.id.dot_notation_key);
        plus = findViewById(R.id.plus_key);
        minus = findViewById(R.id.minus_key);
        multi = findViewById(R.id.multiple_key);
        devide = findViewById(R.id.devide_key);
        moduler = findViewById(R.id.moduler_key);
        equal = findViewById(R.id.make_result_key);
        result = findViewById(R.id.number_result);
        clear = findViewById(R.id.clear_key);

        del = findViewById(R.id.delete_key);
    }

    private void setupListeners(){
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 0;
                result.setText(temp);
                isnum = true;
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 1;
                result.setText(temp);
                isnum = true;
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 2;
                result.setText(temp);
                isnum = true;
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 3;
                result.setText(temp);
                isnum = true;
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 4;
                result.setText(temp);
                isnum = true;
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 5;
                result.setText(temp);
                isnum = true;
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 6;
                result.setText(temp);
                isnum = true;
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 7;
                result.setText(temp);
                isnum = true;
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 8;
                result.setText(temp);
                isnum = true;
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + 9;
                result.setText(temp);
                isnum = true;
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = null;
                second = null;
                operator = "";
                temp = "";
                result.setText("0");
                isnum = false;
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum){//그 전에 누른 게 숫자일 때 -> 계산할 게 있으면 계산, 없으면 계산 ㄴㄴ,op만 바꿈
                    if(first != null){//계산할 게 있는 경우 -> first에 수가 았다.
                        second = Float.parseFloat(temp);
                        calculate();
                        operator = "+";
                        temp = "";
                        isnum = false;
                    }else{//계산할 게 없고 그냥 op만 바꾸면 됨
                        if(!temp.equals("")){
                            first = Float.parseFloat(temp);
                        }
                        operator = "+";
                        temp = "";
                        isnum = false;
                    }
                }else{//아닐 때 -> 같은 op면 return, 다른 op면 op만 바꾸고 return
                    if(operator.equals("+")){
                        return;
                    }else{
                        operator = "+";
                        return;
                    }
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum){//그 전에 누른 게 숫자일 때 -> 계산할 게 있으면 계산, 없으면 계산 ㄴㄴ,op만 바꿈
                    if(first != null && !temp.equals("")){//계산할 게 있는 경우 -> first에 수가 았다.
                        second = Float.parseFloat(temp);
                        calculate();
                        operator = "-";
                        temp = "";
                        isnum = false;
                    }else{//계산할 게 없고 그냥 op만 바꾸면 됨
                        if(!temp.equals("")){
                            first = Float.parseFloat(temp);
                        }
                            operator = "-";
                            temp = "";
                            isnum = false;
                    }
                }else{//아닐 때 -> 같은 op면 return, 다른 op면 op만 바꾸고 return
                    if(operator.equals("-")){
                        return;
                    }else{
                        operator = "-";
                        return;
                    }
                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum){//그 전에 누른 게 숫자일 때 -> 계산할 게 있으면 계산, 없으면 계산 ㄴㄴ,op만 바꿈
                    if(first != null){//계산할 게 있는 경우 -> first에 수가 았다.
                        second = Float.parseFloat(temp);
                        calculate();
                        operator = "*";
                        temp = "";
                        isnum = false;
                    }else{//계산할 게 없고 그냥 op만 바꾸면 됨
                        if(!temp.equals("")){
                            first = Float.parseFloat(temp);
                        }
                        operator = "*";
                        temp = "";
                        isnum = false;
                    }
                }else{//아닐 때 -> 같은 op면 return, 다른 op면 op만 바꾸고 return
                    if(operator.equals("*")){
                        return;
                    }else{
                        operator = "*";
                        return;
                    }
                }
            }
        });

        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum){//그 전에 누른 게 숫자일 때 -> 계산할 게 있으면 계산, 없으면 계산 ㄴㄴ,op만 바꿈
                    if(first != null){//계산할 게 있는 경우 -> first에 수가 았다.
                        second = Float.parseFloat(temp);
                        calculate();
                        operator = "/";
                        temp = "";
                        isnum = false;
                    }else{//계산할 게 없고 그냥 op만 바꾸면 됨
                        if(!temp.equals("")){
                            first = Float.parseFloat(temp);
                        }
                        operator = "/";
                        temp = "";
                        isnum = false;
                    }
                }else{//아닐 때 -> 같은 op면 return, 다른 op면 op만 바꾸고 return
                    if(operator.equals("/")){
                        return;
                    }else{
                        operator = "/";
                        return;
                    }
                }
            }
        });

        moduler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum){//그 전에 누른 게 숫자일 때 -> 계산할 게 있으면 계산, 없으면 계산 ㄴㄴ,op만 바꿈
                    if(first != null){//계산할 게 있는 경우 -> first에 수가 았다.
                        second = Float.parseFloat(temp);
                        calculate();
                        operator = "%";
                        temp = "";
                        isnum = false;
                    }else{//계산할 게 없고 그냥 op만 바꾸면 됨
                        if(!temp.equals("")){
                            first = Float.parseFloat(temp);
                        }
                        operator = "%";
                        temp = "";
                        isnum = false;
                    }
                }else{//아닐 때 -> 같은 op면 return, 다른 op면 op만 바꾸고 return
                    if(operator.equals("%")){
                        return;
                    }else{
                        operator = "%";
                        return;
                    }
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = temp + ".";
                result.setText(temp);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp.length() == 0) return;

                temp = temp.substring(0,temp.length()-1);
                result.setText(temp);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isnum && first != null){
                    second = Float.parseFloat(temp);
                    calculate();
                    operator = "";
                    temp = "";
                    isnum = false;
                }
            }
        });


    }


    private void calculate(){
        float r = 0;
        switch (operator){
            case "+" :
                r = first + second;
                break;
            case "-" :
                r = first - second;
                break;
            case "*" :
                r = first * second;
                break;
            case "/" :
                r = first / second;
                break;
            case "%" :
                r = first % second;
                break;
            default:break;
        }
        first = r;
        second = null;
        //operator = "";
        result.setText(String.valueOf(r));
    }
}
