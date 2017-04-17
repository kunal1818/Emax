package com.example.android.emax;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * main screen
 */
public class SplashActivity extends AppCompatActivity {

    private static final int I = 2000;
    private static final int REQUEST_CODE = 2;
    private Button login, signup;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        login = (Button) findViewById(R.id.btnLogin);
        signup = (Button) findViewById(R.id.btnSignUp);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                login.setVisibility(View.VISIBLE);
                signup.setVisibility(View.VISIBLE);
            }
        }, I);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    /**
     *
     * @param requestCode return request code
     * @param resultCode return result code
     * @param intent  passing from one to another
     */
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        if (resultCode == RESULT_OK) {
            Intent intent1 = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent1);
            finish();

        } else if (resultCode == RESULT_FIRST_USER) {
            Intent intent2 = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent2);
            finish();
        } else {
            Toast.makeText(SplashActivity.this, "wrong result code", Toast.LENGTH_LONG).show();

        }
    }

}

