package com.diygreen.widgetuse;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

public class LedTextActivity extends AppCompatActivity {

    private static final String DATE_FORMAT = "%02d:%02d:%02d";
    private static final int REFRESH_DELAY = 500;

    private TextView mClockTimeTV;

    private final Handler mHandler = new Handler();
    private final Runnable mTimeRefresher = new Runnable() {
        @Override
        public void run() {
            final Date d = new Date();
            mClockTimeTV.setText(String.format(DATE_FORMAT, d.getHours(),
                    d.getMinutes(), d.getSeconds()));
            mHandler.postDelayed(this, REFRESH_DELAY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_text);

        initView();
    }

    private void initView() {
        mClockTimeTV = (TextView) findViewById(R.id.tv_clock_time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.post(mTimeRefresher);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mTimeRefresher);
    }
}
