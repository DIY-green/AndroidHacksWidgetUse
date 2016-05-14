package com.diygreen.widgetuse;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class FormDateValidateActivity extends AppCompatActivity {

    private static final int DATE_DIALOG_ID = 1;
    private static final int DATE_DIALOG2_ID = 2;

    private EditText mDateET;
    private Button mDateBtn;

    private int mYear;
    private int mMonth;
    private int mDay;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formdatevalidate);

        initData();
        initView();
        initListener();
    }

    private void initListener() {
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                String dateStr = getString(R.string.picked_date_format, monthOfYear,
                        dayOfMonth, year);
                Toast.makeText(
                        FormDateValidateActivity.this,
                        dateStr, Toast.LENGTH_SHORT).show();
                mDateET.setText(dateStr);
            }
        };
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                String dateStr = getString(R.string.picked_date_format, monthOfYear,
                        dayOfMonth, year);
                Toast.makeText(
                        FormDateValidateActivity.this,
                        dateStr, Toast.LENGTH_SHORT).show();
                mDateBtn.setText(dateStr);
            }
        };
    }

    private void initData() {
        // get the current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
    }

    private void initView() {
        mDateET = (EditText) findViewById(R.id.et_date);
        mDateBtn = (Button) findViewById(R.id.btn_date);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_date:
                showDialog(DATE_DIALOG_ID);
                break;
            case R.id.btn_date:
                new DatePickerDialog(this, mDateSetListener2, mYear,
                        mMonth, mDay).show();
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener1, mYear,
                        mMonth, mDay);
        }
        return super.onCreateDialog(id);
    }
}
