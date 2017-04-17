package com.example.android.emax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * login page is created here
 */
public class LoginActivity extends AppCompatActivity {
    private Button button;
    private String emailm;
    private Boolean isChecked = true;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.btnLoginPage);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                boolean b = checkValidation();
                if (b == isChecked) {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "enter details again", Toast.LENGTH_LONG).show();
                }
            }
        });

        TextView tvforgot = (TextView) findViewById(R.id.tv_forgot_password);
        tvforgot.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                final Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        TextView tvsign = (TextView) findViewById(R.id.tv_sign_up_loginpage);
        tvsign.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                final Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     *
     * @return email and password after validation
     */
    private boolean checkValidation() {
        EditText email = (EditText) findViewById(R.id.ed_Email);
        emailm = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.ed_Password);
        if (isValidemail(emailm)) {
            return true;
        } else {
            email.setError("Invalid email");
            return false;
        }


    }

    /**
     *
     * @param email get email
     * @return  return after validation
     */
    private boolean isValidemail(final String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}