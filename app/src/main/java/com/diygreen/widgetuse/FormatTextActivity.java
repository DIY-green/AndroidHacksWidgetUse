package com.diygreen.widgetuse;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class FormatTextActivity extends AppCompatActivity {

    private TextView mTestTV1;
    private TextView mTestTV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format_text);

        initView();
        initData();
    }

    private void initView() {
        mTestTV1 = (TextView) findViewById(R.id.tv_showresult);
        mTestTV2 = (TextView) findViewById(R.id.tv_test2);
    }

    private void initData() {
        String htmlText = "<a href=\"http://diy-green.github.io/\">我是链接</a>哈哈<font color='#ff0000'>@XXX<font>";
        mTestTV1.setText(Html.fromHtml(htmlText));

        Spannable spannableString = new SpannableString("我是不同颜色的文本，哈哈，不同颜色文本");
        spannableString.setSpan(new BackgroundColorSpan(Color.RED), 1, 4, 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 5, 9, 0);
        mTestTV2.setText(spannableString);
    }
}
