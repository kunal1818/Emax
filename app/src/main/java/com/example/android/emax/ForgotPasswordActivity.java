package com.example.android.emax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *  forgot password page
 */
public class ForgotPasswordActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        tv = (TextView) findViewById(R.id.tv_custom);
        tv.setText("Forgot Password");
    }
}
