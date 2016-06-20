package com.example.administrator.popupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    View view;
    PopupWindow pop;
    Button btnShowAsDrawDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAsDrawDown = (Button) findViewById(R.id.btnShowAsDrawDown);
        btnShowAsDrawDown.setOnClickListener(this);
        initPopupWindow();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnShowAsDrawDown:
                if (pop.isShowing()) {
                    pop.dismiss();
                } else {
//                    pop.showAsDropDown(v);    // v 的左下角
//                    pop.showAsDropDown(v, 0, -160);  // v 左下角为原点 偏移（x,y）个向量单位
                    View view = findViewById(R.id.main);
                    pop.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);//view 的居中
                }
                break;
        }

    }

    private void initPopupWindow() {
        view = this.getLayoutInflater().inflate(R.layout.popup_window, null);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        pop.setOutsideTouchable(true);// 控制popupwindow点击屏幕其他地方消失
//        pop.setBackgroundDrawable(this.getResources().getDrawable(R.mipmap.ic_launcher));// 设置时才会点击外部消息
        pop.setBackgroundDrawable(getResources().getDrawable(android.R.color.white));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pop.dismiss();
            }
        });
        Button button1 = (Button) view.findViewById(R.id.btn_1);
        Button button2 = (Button) view.findViewById(R.id.btn_2);
        Button button3 = (Button) view.findViewById(R.id.btn_3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                pop.dismiss();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                pop.dismiss();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                pop.dismiss();
            }
        });

    }

}
