package com.diygreen.widgetuse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GetViewWHActivity extends AppCompatActivity {

    private TextView mShowResult1TV;
    private TextView mShowResult2TV;
    private Button mTest1Btn;
    private Button mTest2Btn;
    private View mTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getviewwh);

        initView();
    }

    private void initView() {
        mShowResult1TV = (TextView) findViewById(R.id.tv_showresult);
        mShowResult2TV = (TextView) findViewById(R.id.tv_showresult2);
        mTest1Btn = (Button) findViewById(R.id.btn_test1);
        mTest2Btn = (Button) findViewById(R.id.btn_test2);
        mTestView = findViewById(R.id.view_test);

        getViewWHByPost(mTestView);
        showViewWH("onCreate()", mShowResult1TV);
    }

    private void showViewWH(String method, TextView textView) {
        String result = method + "方法中获取 ShowResultTV 的 w：" +
                textView.getWidth() +
                " h：" + textView.getHeight() + "\n" +
                "Test1Btn 的 w：" +
                mTest1Btn.getWidth() +
                " h：" + mTest1Btn.getHeight() + "\n" +
                "Test2Btn 的 w：" +
                mTest2Btn.getWidth() +
                " h：" + mTest2Btn.getHeight();
        textView.setText(result);
    }

    public void onClick(View v) {
        getViewWHByPost(v);
    }

    private void getViewWHByPost(final View v) {
        v.post(new Runnable() {
            @Override
            public void run() {
                String size = String.format("View's width: %d, height: %d",
                        v.getWidth(), v.getHeight());
                Toast.makeText(GetViewWHActivity.this, size, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showViewWH("onResume()", mShowResult2TV);
    }
}
